package controller.user;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import beans.Item;
import beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.ItemDAO;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR="/home/"+System.getProperty("user.name")+"/ibid/items";
 
    public AddItem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String itemCondition = request.getParameter("itemCondition");
            int minIncrement = Integer.parseInt(request.getParameter("minIncrement"));
            String category = request.getParameter("category");
            int startPrice = Integer.parseInt(request.getParameter("startPrice"));
            User seller  = user;
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String savePath = File.separator + SAVE_DIR;
            System.out.println(startDate+" "+startTime);
            String start = startDate+" "+startTime;
            String end = endDate+" "+endTime;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime s = LocalDateTime.parse(start, formatter);
            LocalDateTime e = LocalDateTime.parse(end, formatter);
            // Combine date and time into timestamps
            Timestamp auctionStartDate = Timestamp.valueOf(s);
            Timestamp auctionEndDate = Timestamp.valueOf(e);
            File fileSaveDir=new File(savePath);
            if(!fileSaveDir.exists()){
                fileSaveDir.mkdirs();
            }

        // File upload
            Part part = request.getPart("itemImage");
            String fileName = System.currentTimeMillis() + "_" + part.getSubmittedFileName();
            String path = savePath + File.separator + fileName;
            part.write(path);

            // Create Item object
            Item item = new Item(title, description, path, itemCondition, minIncrement, category, startPrice, auctionStartDate, auctionEndDate, seller);
        

            // Save item to database
            ItemDAO itemDAO = new ItemDAO();
            if (itemDAO.add(item)) {
                response.sendRedirect("myitems");
                return;
            } else {
                try {
                    throw new SQLException("Failed to add item to database");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else{
            response.sendRedirect("signin");
        }
        
	}
}
