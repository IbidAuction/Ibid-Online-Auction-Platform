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
    <title>Admin Profile</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
        <% String email = (String) session.getAttribute("AdminEmail");
            AdminDAO currDAO = new AdminDAO();
            Admin currAdmin = currDAO.getAdminByEmail(email);
            String picture = currAdmin.getPicture();
        if (currAdmin.getRole().equals("userAdmin")) { %>
            <jsp:include page="adminheader.jsp" />
        <% }else if (currAdmin.getRole().equals("itemAdmin")){ %>
            <jsp:include page="ItemAdminheader.jsp" />
        <% } else { %>
            <jsp:include page="Managerheader.jsp" />
        <% } %>

        <div class="center-div">
            <p class="public-profile">Pubic Profile</p>

            <form action="changeAdminPicture" method="POST" enctype="multipart/form-data">
                <div class="image-and-button">
                    <div class="image">
                        <% System.out.println("picture path : " + picture); %>
                        <img src=<%=picture%> class="admin-image" id="admin-image"/>
                    </div>
                    <div class="buttons">
                        <input type="file" name="imageFile" accept="image/*" style="display: none;" id="upload-input" onchange="handleImageChange(event)">
                        <% System.out.println("Client side checking email: " + currAdmin.getAdminID()); %>
                        <input type="hidden" name="adminId" value ="<%=currAdmin.getAdminID()%>" />
                        <label for="upload-input" class="change-picture">Change Picture</label>
                    </div>
                </div>
                <input type="submit" value="Upload" style="display: none;" id="upload-submit"/>
            </form>

            <form action="EditAdminProfile" method="POST">
                <div class="name-and-email">
                    <div class="name">
                        <div class="first-name-div">
                            <p class="first-name">First Name</p>
                            <input type="text" value="<%=currAdmin.getFirstName()%>" class="first-name-text" name="first-name-text" readonly/>
                        </div>

                        <div class="last-name-div">
                            <p class="last-name">Last Name</p>
                            <input type="text" value="<%=currAdmin.getLastName()%>" class="last-name-text" name = "last-name-text" readonly/>
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

                    <button type="button" class="edit-profile" onclick="enableEdit()">Edit</button>
                    <button type="submit" class="save-profile" style="display: none;">Save</button>
                </div>
            </form>
    <% } %>

    <script>
        function handleImageChange(event) {
            const file = event.target.files[0];
            const imagePathElement = document.getElementById('admin-image');
            imagePathElement.src = URL.createObjectURL(file);

            document.getElementById('upload-submit').click();
        }

        function enableEdit() {
            var firstNameInput = document.querySelector(".first-name-text");
            var lastNameInput = document.querySelector(".last-name-text");
            var editButton = document.querySelector(".edit-profile");
            var saveButton = document.querySelector(".save-profile");

            firstNameInput.removeAttribute("readonly");
            lastNameInput.removeAttribute("readonly");

            editButton.style.display = "none";
            saveButton.style.display = "block";

            saveButton.addEventListener("click", function() {
                firstNameInput.setAttribute("readonly", "readonly");
                lastNameInput.setAttribute("readonly", "readonly");
                editButton.style.display = "block";
                saveButton.style.display = "none";
            });
        }
    </script>

</body>
</html>