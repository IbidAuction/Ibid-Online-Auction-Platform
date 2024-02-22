package controller.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import beans.Item;
import beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ItemDAO;

/**
 * Servlet implementation class UserProfile
 */
public class ItemImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ItemImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemid = Integer.parseInt(request.getParameter("name"));
        ItemDAO itemDAO = new ItemDAO();
        Item item = itemDAO.get(itemid);
		User user = (User)request.getSession().getAttribute("user");
		String path = item.getItemImage();
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("error not found image");
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
		}
		FileInputStream inputStream = new FileInputStream(file);
        try {
            byte[] imageData = new byte[(int) file.length()];
            int bytesRead = inputStream.read(imageData);
            if (bytesRead != imageData.length) {
                throw new IOException("Error reading image data");
            }
            response.setContentType("image/png"); // Adjust for image type
            response.setContentLength(imageData.length);
            response.getOutputStream().write(imageData);
        } finally {
            inputStream.close();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
