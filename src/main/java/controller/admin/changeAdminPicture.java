package controller.admin;

import java.io.IOException;

import beans.Admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.AdminDAO;

public class changeAdminPicture extends HttpServlet{
    
    @SuppressWarnings("static-access")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession(false);
        try{
            String email = (String) session.getAttribute("AdminEmail");
            AdminDAO currDAO = new AdminDAO();
            Admin ad = currDAO.getAdminByEmail(email);

            Part imagePart = request.getPart("imageFile");
            String imageName = getSubmittedFileName(imagePart);
            String imagePath = imageName;
            System.out.println("Image path: " + imagePath);

            Integer Status = 0;
            String relative = "images/adminimage/"  + imagePath;
            Status = currDAO.updateprofileImage(ad, relative);
            
            imagePart.write(imagePath);

            if (Status > 0){
                System.out.println("Image uploaded successfully!");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/useradminprofile.jsp");
                rd.forward(request, response);
            }
            else{
                System.out.println("image upload not successfull");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private String getSubmittedFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}

