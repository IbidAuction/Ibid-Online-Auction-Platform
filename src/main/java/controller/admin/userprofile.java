package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class userprofile extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession currSession = request.getSession(false);
        if (currSession != null){
            String useremail =request.getParameter("user-email");
            System.out.println(useremail + " service");
            request.setAttribute("user-email", useremail);
            RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
            dispatcher.forward(request, response);    
        }
        else{
            response.sendRedirect("notfound.jsp");
        }
    }
}
