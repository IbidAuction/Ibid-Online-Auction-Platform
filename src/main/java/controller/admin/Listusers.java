package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Listusers extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();

        if (session != null){
            String adminemail = (String) session.getAttribute("AdminEmail");
            System.out.println(adminemail + " list users servlet");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Listusers.jsp");
            dispatcher.forward(request, response);    
        }
        else{
            response.sendRedirect("notfound.jsp");
        }
    }


}
