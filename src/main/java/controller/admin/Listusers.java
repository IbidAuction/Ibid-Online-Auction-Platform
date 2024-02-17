package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



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
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/Listusers.jsp");
            dispatcher.forward(request, response);    
        }
        else{
            response.sendRedirect("WEB-INF/admin/notfound.jsp");
        }
    }


}
