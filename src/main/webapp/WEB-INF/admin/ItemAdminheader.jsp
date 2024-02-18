<%@page import="service.UserDAO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.User"%>
<%@page import="jakarta.servlet.http.HttpServlet.*"%>
<%@page import="beans.Admin"%>
<%@page import="service.AdminDAO"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/useradmindash.css">
    <link rel="stylesheet" href="css/listuser.css">
    <script src="js/d3.js"></script>
    <script src="js/plot.js"></script>
    <title>User Admin</title>
</head>
<body>
    <header class="header">
        <div class="name-initials">
            <% String email = (String) session.getAttribute("AdminEmail");
                AdminDAO currDAO = new AdminDAO();
                Admin currAdmin = currDAO.getAdminByEmail(email);
                String picture = currAdmin.getPicture();
            %>
            <img src="<%=picture%>" class="admin-top-image"/>
            
            <p><%=currAdmin.getFirstName()%> <%=currAdmin.getLastName()%></P> 
        </div>
        <form action="SearchItems" method="POST">
            <div class="search-obj">
                <div class="category"><span>&#x1F50D;</span></div>
                <input type="text" placeholder="Write First Name..." class="search-input" name = "search-user">
                <button type="submit" class="search-button">Search</button>
            </div>
        </form>

        <div class="notification-bell">
            <img src="images/notification-bell.png"/>
        </div>
    </header>
    <nav class="nav">
        <form action="adminsignin" method="POST">
            <button type="submit" class="dash-button" id="dash-id"><span><img src="images/application (1).png"/></span> <span>Dashboard</span></button>
        </form>

        <form action="ListItems" method="POST">
            <button type="submit" class="all-users-button" id="all-users-button"><span><img src="images/group.png"/></span><span>All Items</span></button>
        </form>

        <form action="ListPending" method="POST">
            <button type="submit" class="banned-users" id="banned-id"><span><img src="images/wall-clock (2).png"/></span><span>Pending Items</span></button>
        </form>

        <form action="profile" method="POST">
            <button type="submit" class="profile" id ="profile-id"><span><img src="images/user.png"/></span><span>Profile</span></button>
        </form>

        <form action="adminlogout" method="POST">
            <button type="submit"  class="logout-button" id = "logout-id"><span><img src="images/logout.png"/></span><span>Log Out</span></button>
        </form>
        <div id = "logo"><img src="images/bid-up-favicon-black.png" class="logo" ></div>
    </nav>
</body>
</html>
