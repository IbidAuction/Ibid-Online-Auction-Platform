package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class viewItemProfile extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession currSession = request.getSession(false);

        String checkadmin = (String) currSession.getAttribute("AdminEmail");
        if (checkadmin != null || ! checkadmin.equals("")){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/viewItemProfile.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/notfound.jsp");
            rd.forward(request, response);
        }
    }
    
}
