package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class listbanned extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("bannedusers.jsp");
        HttpSession currSession = request.getSession(false);

        if( currSession != null){
            dispatcher.forward(request, response);
        }
        else{
            response.sendRedirect("notfound.jsp");
        }
    }
}
