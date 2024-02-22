package controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
		User user = (User) sess.getAttribute("user");
        if( user != null) {
        	ItemDAO itemDAO = new ItemDAO();
        	List<Item> items = itemDAO.getAll().stream().filter(s->(s.getSeller().getUserID()!=user.getUserID())).collect(Collectors.toList());
			HashMap<Item,List<Long>> remainingtime = new HashMap<>();
           for (Item item : items) {
				long end = item.getAuctionEndDate().getTime();
				long now = System.currentTimeMillis();
				long remain = end-now;
				List<Long> times = new ArrayList<>();
				long days = TimeUnit.MILLISECONDS.toDays(remain);
				long hour = TimeUnit.MILLISECONDS.toHours(remain) % 24;
				long minute = TimeUnit.MILLISECONDS.toMinutes(remain) % 60;
				long sec = TimeUnit.MILLISECONDS.toSeconds(remain) % 60;
				times.add(days);
				times.add(hour);
				times.add(minute);
				times.add(sec);
				remainingtime.put(item, times);
		   }
			request.setAttribute("items", items);
			request.setAttribute("remaining", remainingtime);
        	System.out.println(items.size());
            RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/user/myhome.jsp");
            dis.forward(request, response);
        } else {
            response.sendRedirect("signin");
        }
	}
}
