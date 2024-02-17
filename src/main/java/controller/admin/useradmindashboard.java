package controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
