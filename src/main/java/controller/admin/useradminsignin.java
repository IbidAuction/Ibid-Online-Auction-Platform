package controller.admin;

import java.io.IOException;

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
        System.out.println("in do get");
        if (session == null){
            response.sendRedirect("WEB-INF/admin/notfound.jsp");
        }
        else{
            response.sendRedirect("WEB-INF/admin/userAdminDashboard.jsp");            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String email, password;
        try{
            System.out.println("new session");

            password = request.getParameter("login-password");
            email = request.getParameter("login-email");

            if (email.equals("") || password.equals("")){
                response.sendRedirect("WEB-INF/admin/notfound.jsp");
            }else{
                HttpSession addis = request.getSession();
                addis.setAttribute("AdminEmail", email);

                Admin currAdmin = AdminDAO.getAdminByEmail(email);
                String role = currAdmin.getRole();
                System.out.println(role + " is role of admin");
                if (role != null && role.equals("userAdmin")){
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/userAdminDashboard.jsp");
                    rd.forward(request, response);
                }else if(role != null && role.equals("itemAdmin")){
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/itemAdminDashboard.jsp");
                    rd.forward(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/notfound.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
