package controller.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserProfile
 */
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user = (User)request.getSession().getAttribute("user");
		String path = user.getProfileImage();
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
