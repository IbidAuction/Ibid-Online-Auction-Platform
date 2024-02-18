package controller.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Navigate extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Navigate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String page = request.getParameter("name");
            switch (page) {
                case "myhome":
                response.sendRedirect("myhome");
                    break;
                case "items":
                response.sendRedirect("myitems");
                    break;
                case "bids":
                response.sendRedirect("mybids");
                    break;
                case "deals":
                response.sendRedirect("mydeals");
                    break;
                case "feedback":
                response.sendRedirect("myfeedback");
                    break;
                case "notification":
                response.sendRedirect("mynotification");
                    break;    
                case "profile":
                response.sendRedirect("myprofile");
                    break;
                default:
                    break;
            }

	}
}
