package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SearchUsers extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession curr = request.getSession(false);
        if (curr != null){
            RequestDispatcher rd = request.getRequestDispatcher("SearchUsers.jsp");
            rd.forward(request, response);    
        }
        else{
            response.sendRedirect("notfound.jsp");
        }
    }
}
