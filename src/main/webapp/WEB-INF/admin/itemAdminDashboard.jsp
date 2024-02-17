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
    <title>Item Admin</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
    String check = (String) checksession.getAttribute("AdminEmail");
    if (check == null || check.equals("")){ %>
        <h1>Page not found</h1> 
    <% } else { %>
        <jsp:include page="ItemAdminheader.jsp" />
        <div class="container">
            <div class="topics">
                <h1 style="color: rgb(38, 149, 255);
                            font-weight: bold;
                            display: block;
                            margin-bottom: 100px;
                            font-family: Arial, Helvetica, sans-serif;">WELCOME !</h1>

                <h2 style="font-weight: bold;
                            display: block;
                            margin-bottom: 50px;
                            font-family: Arial, Helvetica, sans-serif;">Item ANALYTICS: </h2>
            </div>
    <% } %> 
</body>
</html>