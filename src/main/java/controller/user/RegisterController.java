package controller.user;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import beans.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.UserDAO;

/**
 * Servlet implementation class RegisterController
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="/home/"+System.getProperty("user.name")+"/ibid/users";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String region = request.getParameter("region");
		String password = request.getParameter("password");
        String savePath = File.separator + SAVE_DIR;
            File fileSaveDir=new File(savePath);
            if(!fileSaveDir.exists()){
                fileSaveDir.mkdirs();
            }

        Part part= request.getPart("image");	
        String fileName = (new Date()).toString();
        User user = new User(firstname, lastname, email, password, city, phone, region, null);
        if(!fileName.equals("")) {
        	String path = savePath + File.separator +fileName;
        	part.write(path);
        	user.setProfileImage(path);
        }
        UserDAO userDAO = new UserDAO();
        if(userDAO.add(user)) {
        	response.sendRedirect("signin.jsp");
        }
        else {
        	request.setAttribute("error", "SOMETHING GOT WRONG PLEASE TRY AGAIN!!!");
        	RequestDispatcher dis = request.getRequestDispatcher("register");
        	dis.forward(request, response);
        }
	}
}
