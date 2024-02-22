package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterAdmin extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession currSession = request.getSession(false);
        String check =(String) currSession.getAttribute("AdminEmail");

        if(check != null && !check.equals("")){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/RegisterAdmin.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/RegisterAdmin.jsp");
            rd.forward(request, response);
        }
    }
}
