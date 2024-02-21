package controller.admin;

import beans.Admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.AdminDAO;

public class EditAdminProfile extends HttpServlet{
    
    @SuppressWarnings("static-access")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            HttpSession currSession = request.getSession(false);
            String email = (String) currSession.getAttribute("AdminEmail");
            if (email != null && !email.equals("")){
                AdminDAO currDao = new AdminDAO();
                Admin curr = currDao.getAdminByEmail(email);
                String firstname = request.getParameter("first-name-text");
                String lastname = request.getParameter("last-name-text");
                curr.setFirstName(firstname);
                curr.setLastName(lastname);
                currDao.update(curr);

                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/admin/useradminprofile.jsp");
                rd.forward(request, response);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
