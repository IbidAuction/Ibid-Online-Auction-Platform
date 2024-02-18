<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.User"%>
<%@page import="beans.Admin"%>
<%@page import="beans.Item"%>
<%@page import="service.ItemDAO"%>
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
        <jsp:include page="ItemAdminheader.jsp" />
        <div class="big-div">
            <form>
                <div class="search-obj">
                    <div class="category"><span>Category &#x25BC;</span></div>
                    <input type="text" placeholder="Search Items..." class="search-input">
                    <button type="submit" class="search-button">Search</button>
                </div>
            </form>

            <%-- the following code gets all users from the database --%>
            <% 
                List<Item>al = new ArrayList<>();
                ItemDAO currDAO = new ItemDAO();
                al = currDAO.getAll();
            %>

            <div >
                <div class="user-list">
                    <% for (Item item: al) { %>
                        <div class="content">
                            <div class="inside">
                                <form action="viewItemProfile" method="POST">
                                    <input type="hidden" name="Item-id" value="<%=item.getItemID()%>">
                                    <img src=<%=item.getItemImage()%> class="image-obj">
                                    <p class="person-name"> <%=item.getTitle()%></p>
                                    <% String status =item.getItemState();
                                        if (status.equals("approved")){ %>
                                            <p class="status" style="color:green;"><%=status%></p>
                                        <% } else if (status.equals("pending")) { %>
                                            <p class="status" style="color:orange;"><%=status%></p>
                                        <% } else { %>
                                            <p class="status" style="color:red;"><%=status%></p>
                                        <% } %>
                                        <button type="submit" class="view-profile-button">View Item</button>
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