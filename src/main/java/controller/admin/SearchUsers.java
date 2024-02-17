package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
