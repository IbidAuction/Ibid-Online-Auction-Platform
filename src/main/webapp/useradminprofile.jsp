<%@page import="beans.Admin"%>
<%@page import="service.AdminDAO"%>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/listuser.css">
    <link rel="stylesheet" href="css/useradmindash.css">
    <link rel="stylesheet" href="css/useradminprofile.css">
    <title>User Admin</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
        <jsp:include page="adminheader.jsp" />
        <% String email = (String) session.getAttribute("AdminEmail");
            AdminDAO currDAO = new AdminDAO();
            Admin currAdmin = currDAO.getAdminByEmail(email);
            String picture = currAdmin.getPicture();
        %>
        <div class="center-div">
            <p class="public-profile">Pubic Profile</p>
            <div class="image-and-button">
                <div class="image">
                    <img src="<%=picture%>" class="admin-image"/>
                </div>
                <div class="buttons">
                    <button class="change-picture">Change Picture</button>
                    <button class="delete-picture">Delete Picture</button>
                </div>
            </div>

            <div class="name-and-email">
                <div class="name">
                    <div class="first-name-div">
                        <p class="first-name">First Name</p>
                        <input type="text" value="<%=currAdmin.getFirstName()%>" class="first-name-text" readonly/>
                    </div>

                    <div class="last-name-div">
                        <p class="last-name">Last Name</p>
                        <input type="text" value="<%=currAdmin.getLastName()%>" class="last-name-text" readonly/>
                    </div>
                </div>

                <div class="email-div">
                    <p class="email-text">Email</p>
                    <input type="text" value="<%=currAdmin.getEmail()%>" class="email-input" readonly/>
                </div>

                <div class="role-div">
                    <p class="role-text">Role</p>
                    <input type="text" value=" <%=currAdmin.getRole()%>" class="email-input" readonly/>
                </div>

            <button class="edit-profile">Edit</button>
        </div>
    <% } %>
</body>
</html>