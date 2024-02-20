<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.User"%>
<%@page import="beans.Admin"%>
<%@page import="beans.Item"%>
<%@page import="service.AdminDAO"%>
<%@page import="jakarta.servlet.http.HttpSession"%>


<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/listuser.css">
    <link rel="stylesheet" href="css/useradmindash.css">
    <title>List Items</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
        <jsp:include page="Managerheader.jsp" />
        <div class="big-div">
            <%-- the following code gets all users from the database --%>
            <% 
                List<Admin>al = new ArrayList<>();
                AdminDAO currDAO = new AdminDAO();
                al = currDAO.getAll();
            %>

            <div >
                <div class="user-list">
                    <% for (Admin admin: al) { %>
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
                </div>
            </div>
        </div>
    <% } %>
</body>
</html>