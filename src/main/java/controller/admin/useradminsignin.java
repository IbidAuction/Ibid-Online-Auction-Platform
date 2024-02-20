package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import beans.Admin;
import service.AdminDAO;

public class useradminsignin extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        if (session == null){
            response.sendRedirect("WEB-INF/admin/notfound.jsp");
        }
        else{
            response.sendRedirect("WEB-INF/admin/userAdminDashboard.jsp");            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String email, password;
        try{
            System.out.println("new session");

            PrintWriter out = response.getWriter();
            password = request.getParameter("login-password");
            email = request.getParameter("login-email");

            if (email.equals("") || password.equals("")){
                out.println("<script>alert('Email and password can not be empty')</script>");
            }else{
                HttpSession addis = request.getSession();
                addis.setAttribute("AdminEmail", email);
                Admin currAdmin = AdminDAO.getAdminByEmail(email);
                String role = currAdmin.getRole();
                System.out.println(currAdmin.getPassword() + password + "check");
                if (role != null && role.equals("userAdmin")){
                    if (currAdmin.getPassword().equals(password)){
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/userAdminDashboard.jsp");
                        rd.forward(request, response);
                        return;
                    }
                    else{
                        out.println("<script>alert('Incorrect Password')</script>");
                    }
                }else if(role != null && role.equals("itemAdmin")){
                    if (currAdmin.getPassword().equals(password)){
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/itemAdminDashboard.jsp");
                        rd.forward(request, response);  
                        return ;
                    }
                    else{
                        out.println("<script>alert('Incorrect Password')</script>");
                    }
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/notfound.jsp");
                    rd.forward(request, response);
                    return ;

                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
