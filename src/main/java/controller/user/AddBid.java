package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import beans.Bid;
import beans.Item;
import beans.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BidDAO;
import service.ItemDAO;

public class AddBid extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddBid() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
        User user = (User)sess.getAttribute("user");
        if(user != null) {
        	int id = Integer.parseInt(request.getParameter("id"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            ItemDAO itemDAO = new ItemDAO();
            Item item = itemDAO.get(id);
            Bid bid = new Bid(item, user, amount);
            BidDAO bidDAO = new BidDAO();
            if(bidDAO.add(bid)){
                response.getWriter().write("ok");
            }
            else{
                response.getWriter().write("no");
            }   
        } else {
            response.sendRedirect("signin");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
