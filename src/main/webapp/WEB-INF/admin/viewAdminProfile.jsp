<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="jakarta.servlet.http.HttpServlet.*"%>
<%@page import="beans.Admin"%>
<%@page import="service.AdminDAO"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/useradmindash.css">
    <link rel="stylesheet" href="css/listuser.css">
    <link rel="stylesheet" href="css/userprofile.css">
    <script src="js/jquery-3.7.1.min.js"></script>
    <style>
        body {
            overflow-y: scroll;
        }
        .big-div {
            max-height: 100vh; 
            overflow-y: auto;
        }
        .activities{
            margin-bottom: 100px;
            padding-bottom: 100px;
        }

        .activities.p{
            font-size:18px;
        }

        .admin-profle-img{
            height: 150px;
            width: 150px;
        }
    </style>
    <title>Admin Profile</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
    <jsp:include page="Managerheader.jsp" />
        <% String AdminID = request.getParameter("Admin-id");
            Integer id = Integer.parseInt(AdminID);
            AdminDAO currDAO = new AdminDAO();
            Admin ad = currDAO.get(id);      
        %>
        <div class="big-div">
            <div class="picture-name">
                <div class="picture">
                    <img src="<%=ad.getPicture()%>"class="user-pofile-picture" class="admin-profle-img"/>
                    <div class="name-and-status">
                        <p class="viewd-user-name">Full Name: <%=ad.getFirstName()%> <%=ad.getLastName()%></p>
                    </div>
                    <button class="ban-activate" style="color:white; background-color:red" data-admin-id="<%=id%>">Delete</button>
                </div>
            </div>
            <div class="activities">
                <h2 style="font-weight: bold;">Full Profile</h2>
                <p>Email : <%=ad.getEmail()%> </p>
                <p>Role: <%=ad.getRole()%> </p>
                <p>Registration Date: <%=ad.getRegisteredDate()%></p>
            </div>
        </div>
        <script>
            $(document).ready(function() {
                $('.ban-activate').on('click', function(){
                    var button = $(this);
                    var Adminid = $(this).data('admin-id');

                    var confirmation = confirm("Are you sure you want to delete this admin?");

                    if (confirmation){
                        $.ajax({
                            url: 'DeleteAdmin',
                            type: 'POST',
                            data: {
                                Adminid : Adminid,
                            },
                            success: function(response){
                                button.closest('.big-div').remove();
                                alert('Admin deleted successfully.');
                            },
                            error: function(){
                                alert('An error occurred. please try again later.');
                            }
                        });
                    }
                });
            });
        </script>
    <% } %>
</body>
</html>