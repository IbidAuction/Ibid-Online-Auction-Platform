package controller.admin;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class useradmindashboard extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession currSession = request.getSession(false);
        if (currSession != null){
            response.sendRedirect("userAdminDashboard.jsp");
        }
        else{
            response.sendRedirect("notfound.jsp");
        }
    }
}
