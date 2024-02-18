package controller.admin;

import java.io.IOException;

import beans.Item;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ItemDAO;

public class changeItemstate extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String Itemid = request.getParameter("ItemId");
        Integer id = Integer.parseInt(Itemid);
        ItemDAO itdao = new ItemDAO();
        Item it = itdao.get(id);

        if (it != null){
            itdao.changeState(it);
        }
        
        response.getWriter().write("Status updated successfully");

    }
}
