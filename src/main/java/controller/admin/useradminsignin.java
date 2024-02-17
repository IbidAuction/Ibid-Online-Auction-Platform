package controller.admin;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        HttpSession session = request.getSession(false);
        String email = request.getParameter("login-email");
        String password = request.getParameter("login-password");
        String adminEmail = (String) session.getAttribute("AdminEmail");
        if (adminEmail == null || adminEmail.equals("")){
            System.out.println("pass" + email + password);
            if (email.equals("") || password.equals("")){
                response.sendRedirect("notfound.jsp");
            }else{
                HttpSession addis = request.getSession();
                addis.setAttribute("AdminEmail", email);
                System.out.println("redirecting");
                response.sendRedirect("userAdminDashboard.jsp");
            }
        }else{
            System.out.println("not");
            response.sendRedirect("userAdminDashboard.jsp");
        }
    }
}
