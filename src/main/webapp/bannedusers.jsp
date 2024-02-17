<%@page import="service.UserDAO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.User"%>
<%@page import="beans.Admin"%>
<%@page import="service.AdminDAO"%>
<%@page import="jakarta.servlet.http.HttpSession"%>


<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/listuser.css">
    <link rel="stylesheet" href="css/useradmindash.css">
    <title>User Admin</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
        <jsp:include page="adminheader.jsp" />
        <div class="big-div">
            <form>
                <div class="search-obj">
                    <div class="category"><span>Category &#x25BC;</span></div>
                    <input type="text" placeholder="Search Users..." class="search-input">
                    <button type="submit" class="search-button">Search</button>
                </div>
            </form>

            <%-- the following code gets all users from the database --%>
            <% 
                List<User>al = new ArrayList<>();
                System.out.println("connection established");
                UserDAO currDAO = new UserDAO();
                al = currDAO.getAll();
                System.out.println(al.size());
            %>

            <div >
                <div class="user-list">
                    <% for (User user: al) { %>
                        <% String status =user.getUserStatus();
                            if ( !status.equals("active")){ %>
                                <form action="viewProfile" method="POST">
                                    <div class="content">
                                        <div class="inside">
                                            <input type="hidden" name="user-email" value="<%=user.getEmail()%>">
                                            <img src=<%=user.getProfileImage()%> class="image-obj">
                                            <p class="person-name"> <%=user.getFirstName()%> <%=user.getLastName()%></p>
                                            <p class="status" style="color:red;"><%=status%></p>
                                            <button  class="view-profile-button">View profile</button>
                                        </div>
                                    </div>
                                </form>
                            <% } %>
                    <% } %>
                </div>
            </div>
        </div>
    <% } %>
</body>
</html>