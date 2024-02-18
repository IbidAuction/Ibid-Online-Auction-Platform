<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.User"%>
<%@page import="jakarta.servlet.http.HttpServlet.*"%>
<%@page import="beans.Item"%>
<%@page import="service.ItemDAO"%>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/useradmindash.css">
    <link rel="stylesheet" href="css/listuser.css">
    <link rel="stylesheet" href="css/userprofile.css">
    <script src="js/jquery-3.7.1.min.js"></script>
    <title>Item detail</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
    <jsp:include page="ItemAdminheader.jsp" />
        <% String Itemid = request.getParameter("Item-id");
            Integer id = Integer.parseInt(Itemid);
            ItemDAO currDAO = new ItemDAO();
            Item it = currDAO.get(id);      
            String status = it.getItemState();
        %>
        <div class="big-div">
            <div class="picture-name">
                <div class="picture">
                    <img src="<%=it.getItemImage()%>" class="user-pofile-picture"/>
                    <div class="name-and-status">
                        <p class="viewd-user-name">Title: <%=it.getTitle()%></p>
                        <% if(status.equals("approved")) { %>
                            <p class="viewd-user-status" >Status: <span style="color:green;"><%=status%></span></p>
                        <% } else if (status.equals("pending")){ %>
                            <p class="viewd-user-status">Status: <span style="color:orange;"><%=status%></span></p>
                        <% } else {%>
                            <p class="viewd-user-status">Status: <span style="color:red;"><%=status%></span></p>
                        <% } %>
                    </div>
                    <% if(status.equals("approved")) { %>
                        <button class="ban-activate" style="color:white; background-color:red" data-item-id="<%=it.getItemID()%>" data-status="<%=status%>">Reject</button>
                    <% } else { %>
                        <button class="ban-activate" style="color:white; background-color:green" data-item-id="<%=it.getItemID()%>" data-status="<%=status%>">Approve</button>
                    <% } %>
                </div>
            </div>
            <div class="activities">
                <p>Description:</p>
                <%=it.getDescription() %>
            </div>
        </div>
        <script>
            $(document).ready(function() {
                $('.ban-activate').on('click', function(){
                    var button = $(this);
                    var Itemid = $(this).data('item-id');
                    var status = $(this).data('status');
                    var newstatus= '';

                    if (status !== "approved"){
                        newstatus = 'approved';
                    } else{
                        newstatus = 'rejected';
                    }
                    $.ajax({
                        url: 'changeItemState',
                        type: 'POST',
                        data: {
                            ItemId : Itemid,
                            newstatus : newstatus
                        },
                        success: function(response){
                            if( newstatus !== 'approved'){
                                button.css('background-color', 'green').text('approve');
                                button.closest('.picture').find('.viewd-user-status').html('Status: <span style="color:red;">' + newstatus + '</span>');
                            } else{
                                button.css('background-color', 'red').text('reject');
                                button.closest('.picture').find('.viewd-user-status').html('Status: <span style="color:green;">' + newstatus + '</span>');
                            }
                        },
                        error: function(){
                            alert('An error occurred. please try again later.');
                        }
                    });
                });
            });
        </script>
    <% } %>
</body>
</html>