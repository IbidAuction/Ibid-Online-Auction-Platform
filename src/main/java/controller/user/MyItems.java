package controller.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import beans.Item;
import beans.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ItemDAO;

public class MyItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MyItems() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User user = (User)sess.getAttribute("user");
		ItemDAO itemDAO = new ItemDAO();
        if(user != null){ 
			List<Item> items = itemDAO.getAll();
			List<Item> pendings = items.stream().filter(s->(s.getSeller().getUserID()==user.getUserID())
			                                                &&(s.getItemState().equals("pending")))
															.collect(Collectors.toList());
			List<Item> upcomings  = items.stream().filter(s->((s.getSeller().getUserID()==user.getUserID())
														    &&(s.getItemState().equals("approved"))
															&&(s.getAuctionStartDate().compareTo((new Timestamp(new Date().getTime())))>0)))
															.collect(Collectors.toList());
			List<Item> actives = items.stream().filter(s->((s.getSeller().getUserID()==user.getUserID())
															&&(s.getItemState().equals("approved"))
															&&(s.getAuctionStartDate().compareTo((new Timestamp(new Date().getTime())))<=0)))
															.collect(Collectors.toList());												
			pendings.forEach(n->System.out.println(n));
			request.setAttribute("pendings", pendings);
			request.setAttribute("upcoming", upcomings);
			request.setAttribute("active", actives);
			RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/user/items.jsp");
			dis.forward(request, response);
        } 
		else {
            response.sendRedirect("signin");
        }
	}
}
