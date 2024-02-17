package controller.admin;

import java.io.IOException;

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
            response.sendRedirect("notfound.jsp");
        }
        else{
            response.sendRedirect("userAdminDashboard.jsp");            
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
                response.sendRedirect("notfound.jsp");
            }else{
                HttpSession addis = request.getSession();
                addis.setAttribute("AdminEmail", email);

                Admin currAdmin = AdminDAO.getAdminByEmail(email);
                String role = currAdmin.getRole();
                System.out.println(role + " is role of admin");

                if (role != null && role.equals("userAdmin")){
                    response.sendRedirect("userAdminDashboard.jsp");
                }else if(role != null && role.equals("itemAdmin")){
                    response.sendRedirect("itemAdminDashboard.jsp");
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
