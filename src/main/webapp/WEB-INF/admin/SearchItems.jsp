<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="jakarta.servlet.http.HttpServlet.*"%>
<%@page import="beans.Admin"%>
<%@page import="beans.Item"%>
<%@page import="service.AdminDAO"%>
<%@page import="service.ItemDAO"%>
<%@page import="jakarta.servlet.http.HttpSession"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/listuser.css">
        <link rel="stylesheet" href="css/useradmindash.css">
        <link rel="stylesheet" href="css/useradminprofile.css">
        <title>Item Admin</title>
    </head>
    <bodY>
        <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
            <jsp:include page="ItemAdminheader.jsp" />
            <% 
                String searchname = request.getParameter("search-item");
                List<Item>targetItems = new ArrayList<>();
                ItemDAO currDAO = new ItemDAO();
                targetItems = currDAO.getItembyName(searchname);
            %>
            <div class="store" style="padding-left: 200px;">
                <div class="user-list">
                    <% for (Item item: targetItems) { %>
                        <div class="content">
                            <div class="inside">
                                <form action="viewItemProfile" method="POST">
                                    <input type="hidden" name="Item-id" value="<%=item.getItemID()%>">
                                    <img src=<%=item.getItemImage()%> class="image-obj">
                                    <p class="person-name"> <%=item.getTitle()%></p>
                                        <% String status =item.getItemState();
                                            if (status.equals("approved")){ %>
                                                <p class="status" style="color:green;"><%=status%></p>
                                            <% } else if (status.equals("pending")) { %>
                                                <p class="status" style="color:orange;"><%=status%></p>
                                            <% } else { %>
                                                <p class="status" style="color:red;"><%=status%></p>
                                            <% } %>
                                        <button type="submit" class="view-profile-button">View Item</button>
                                </form>
                            </div>
                        </div>
                    <% } %>
                <div>
            </div>
        <% } %>
    </body>
</html>