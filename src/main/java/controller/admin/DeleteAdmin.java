package controller.admin;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.AdminDAO;

public class DeleteAdmin extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        HttpSession currSession = request.getSession(false);
        String check =(String) currSession.getAttribute("AdminEmail");

        if(check != null && !check.equals("")){
            AdminDAO currDao = new AdminDAO();
            String sid = request.getParameter("Adminid");
            Integer id = Integer.parseInt(sid);

            if (currDao.delete(id)){
                System.out.println("Success deleting admin");
            }else{
                System.out.println("delet failed!!!");
            }
        }
    }
    
}
