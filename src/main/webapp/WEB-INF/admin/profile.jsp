<%@page import="service.UserDAO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.User"%>
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
    <title>User Profile</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
    <jsp:include page="adminheader.jsp" />
        <% String useremail = (String) request.getAttribute("user-email");
            UserDAO currDAO = new UserDAO();
            User viewuser = currDAO.getUserbyEmail(useremail); 
            String status = viewuser.getUserStatus();    
        %>
        <div class="big-div">
            <div class="picture-name">
                <div class="picture">
                    <img src="<%=viewuser.getProfileImage()%>" class="user-pofile-picture"/>
                    <div class="name-and-status">
                        <p class="viewd-user-name">Full Name: <%=viewuser.getFirstName()%><%=viewuser.getLastName()%></p>
                        <% if(status.equals("active")) { %>
                            <p class="viewd-user-status" >Status: <span style="color:green;"><%=status%></span></p>
                        <% } else { %>
                            <p class="viewd-user-status" >Status: <span style="color:red;"><%=status%></span></p>
                        <% } %>
                    </div>
                    <% if(status.equals("active")) { %>
                        <button class="ban-activate" style = "color:white; background-color:red" data-user-id="<%=viewuser.getUserID()%>">Ban</button>
                    <% } else { %>
                        <button class="ban-activate" style="color:white; background-color:green" data-user-id="<%=viewuser.getUserID()%>">Activate</button>
                    <% } %>
                </div>
            </div>
            <div class="activities">
                <p>Recent Activity</p>
            </div>
        </div>
        <script>
            $(document).ready(function() {
                $('.ban-activate').on('click', function(){
                    var button = $(this);
                    var userId = $(this).data('user-id');
                    var newstatus= '';

                    if($(this).css('background-color') === 'rgb(255, 0, 0)'){
                        newstatus = 'banned';
                    } else{
                        newstatus = 'active';
                    }
                    $.ajax({
                        url: 'changeState',
                        type: 'POST',
                        data: {
                            userId : userId,
                            newstatus : newstatus
                        },
                        success: function(response){
                            if( newstatus === 'banned'){
                                button.css('background-color', 'green').text('Activate');
                                button.closest('.picture').find('.viewd-user-status').html('Status: <span style="color:red;">' + newstatus + '</span>');
                            } else{
                                button.css('background-color', 'red').text('Ban');
                                button.closest('.picture').find('.viewd-user-status').html('Status: <span style="color:green;">' + newstatus + '</span>');
                            }
                        },
                        error: function(){
                            alert('An error occured. please try again later.');
                        }
                    });
                });
            });
        </script>
    <% } %>
</body>
</html>