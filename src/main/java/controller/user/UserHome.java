package controller.user;

import java.io.IOException;
import java.util.List;

import beans.Item;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ItemDAO;

public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UserHome() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
        if(sess.getAttribute("user") != null) {
        	ItemDAO itemDAO = new ItemDAO();
        	List<Item> items = itemDAO.getAll();
        	request.setAttribute("items", items);
        	System.out.println(items.size());
            RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/myhome.jsp");
            dis.forward(request, response);
        } else {
            response.sendRedirect("signin.jsp");
        }
	}

}
