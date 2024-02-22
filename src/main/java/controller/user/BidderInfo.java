package controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import beans.Bid;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BidDAO;

public class BidderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Gson gson = new Gson();
 
    public BidderInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        BidDAO bidDAO = new BidDAO();
        
        if(sess.getAttribute("user") != null) {
        	List<Bid> bids = bidDAO.getAll().stream().filter(s->(s.getItem().getItemID()==id)).collect(Collectors.toList());
            String bidsjson = this.gson.toJson(bids);
            System.out.println(bids);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(bidsjson);
            out.flush();   
        } else {
            response.sendRedirect("signin");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
