package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class useradmindashboard extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession currSession = request.getSession(false);
        if (currSession != null){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/userAdminDashboard.jsp");
            rd.forward(request, response);
        }
        else{
            response.sendRedirect("WEB-INF/admin/notfound.jsp");
        }
    }
}
