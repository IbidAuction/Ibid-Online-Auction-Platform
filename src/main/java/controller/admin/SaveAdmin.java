package controller.admin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import beans.Admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.AdminDAO;

public class SaveAdmin extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        System.out.println("in save admin");
        HttpSession currSession = request.getSession(false);
        String check =(String) currSession.getAttribute("AdminEmail");

        try{
            if (check != null && !check.equals("")){
                String test =(String) request.getParameter("test");
                String fname = request.getParameter("first-name");
                String lname = request.getParameter("last-name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String role = request.getParameter("AdminRole");

                System.out.println(test + "testing " + fname);
                String uploadPath = "images/adminimage/default.jpg";
                AdminDAO currDao = new AdminDAO();
                Admin newAdmin = new Admin(fname, lname, role, email, password, uploadPath);
                currDao.add(newAdmin);

                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/RegisterAdmin.jsp");
                rd.forward(request, response);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
