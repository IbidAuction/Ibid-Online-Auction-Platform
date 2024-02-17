package controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserDAO;
import beans.User;


public class changeuserstate extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String UserId = request.getParameter("userId");
        Integer id = Integer.parseInt(UserId);
        User targ = UserDAO.getUserbyId(id);

        if (targ != null){
            UserDAO.changeState(targ);
        }
        response.getWriter().write("Status updated successfully");
    }
}
