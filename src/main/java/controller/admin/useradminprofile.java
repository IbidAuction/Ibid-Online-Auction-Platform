package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class useradminprofile extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession currSession = request.getSession(false);
        if (currSession != null){
            RequestDispatcher rd = request.getRequestDispatcher("useradminprofile.jsp");
            rd.forward(request, response);
        }
        else{
            response.sendRedirect("notfound.jsp");
        }
    }
}
