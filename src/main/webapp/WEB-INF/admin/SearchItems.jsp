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
        <title>User Admin</title>
    </head>
    <bodY>
        <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
            <jsp:include page="adminheader.jsp" />
            <% 
                String searchname = request.getParameter("search-user");
                List<User>targetUsers = new ArrayList<>();
                UserDAO currDAO = new UserDAO();
                targetUsers = currDAO.getUserbyName(searchname);
            %>
            <div class="store" style="padding-left: 200px;">
                <div class="user-list">
                    <% for (User user: targetUsers) { %>
                        <div class="content">
                            <div class="inside">
                                <form action="viewProfile" method="POST">
                                    <input type="hidden" name="user-email" value="<%=user.getEmail()%>">
                                    <img src=<%=user.getProfileImage()%> class="image-obj">
                                    <p class="person-name"> <%=user.getFirstName()%> <%=user.getLastName()%></p>
                                    <% String status =user.getUserStatus();
                                        if (status.equals("active")){ %>
                                            <p class="status" style="color:green;"><%=status%></p>
                                        <% } else{ %>
                                            <p class="status" style="color:red;"><%=status%></p>
                                        <% } %>
                                        <button type="submit" class="view-profile-button">View profile</button>
                                </form>
                            </div>
                        </div>
                    <% } %>
                <div>
            </div>
        <% } %>
    </body>
</html>