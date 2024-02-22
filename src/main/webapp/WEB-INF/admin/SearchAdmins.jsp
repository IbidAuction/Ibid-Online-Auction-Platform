<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="jakarta.servlet.http.HttpServlet.*"%>
<%@page import="beans.Admin"%>
<%@page import="service.AdminDAO"%>
<%@page import="jakarta.servlet.http.HttpSession"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/listuser.css">
        <link rel="stylesheet" href="css/useradmindash.css">
        <link rel="stylesheet" href="css/useradminprofile.css">
        <title>Admins</title>
    </head>
    <bodY>
        <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
            <jsp:include page="adminheader.jsp" />
            <% 
                String searchname = request.getParameter("search-admin");
                List <Admin> targetadmins = new ArrayList<>();
                AdminDAO currDAO = new AdminDAO();
                targetadmins = currDAO.getAdminbyName(searchname);
            %>
            <div class="store" style="padding-left: 200px;">
                <div class="user-list">
                   <% for (Admin admin : targetadmins) { %>
                        <div class="content">
                            <div class="inside">
                                <form action="viewAdminProfile" method="POST">
                                    <input type="hidden" name="Admin-id" value="<%=admin.getAdminID()%>">
                                    <img src=<%=admin.getPicture()%> class="image-obj">
                                    <p class="person-name"> <%=admin.getFirstName()%> <%=admin.getLastName()%></p>
                                    <p>Role: <%=admin.getRole()%> </p>
                                    <button type="submit" class="view-profile-button">View Profile</button>
                                </form>
                            </div>
                        </div>
                    <% } %>
                <div>
            </div>
        <% } %>
    </body>
</html>