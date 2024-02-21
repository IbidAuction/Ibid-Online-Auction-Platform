<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="js/jquery-3.7.1.min.js"></script>
    <title>Register Admin</title>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .whole-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 50px;
            margin-left:700px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .buttons{
            margin-top:20px;
            display:flex;
            justify-content: space-between;
        }

        .submit-button,
        .register-button {
            background-color: rgb(38, 149, 255);
            border: none;
            color: white;
            font-weight: 400;
            font-size: 16px;
            border-radius: 30px;
            padding-left: 15px;
            padding-right: 15px;
            padding-top: 7px;
            padding-bottom: 7px;
            cursor: pointer ;
        }

        .submit-button:hover,
        .register-button:hover{
            opacity:0.7;
        }

        .submit-button:active,
        .register-button:active{
            opacity:0.4;
        }

        input{
            border-radius: 5px;
            border-color: lightgray;
            height: 20px;
            padding-left: 10px;
            padding-right: 10px;
            border-radius: 5px;
        }

        p{
            font-family: Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
        String check = (String) checksession.getAttribute("AdminEmail");
        if (check == null || check.equals("")){ %>
            <h1>Page not found</h1> 
        <% } else { %>
            <jsp:include page="Managerheader.jsp"/>
            <div class="whole-container">
                <form action="SaveAdmin" method="POST">
                    <h2 class="admin-reg">Admin Registration</h2>
                    <p class="low">Enter the information below to register an admin</p>
                    <p>First Name</p>
                    <input type="hidden" name="test" value ="test"/>
                    <input type="text" placeholder="first-name" name="first-name" id="first-name" required/>
                    <p>Last Name</p>
                    <input type="text" placeholder="last-name" name="last-name" id="last-name" required/>
                    <p>Email</p>
                    <input type="email" placeholder="Email.." name="email" id="email" required/>
                    <p>Role</p>
                    <select name="AdminRole" id="AdminRole">
                        <option value="userAdmin">User Admin</option>
                        <option value="itemAdmin">Item Admin</option>
                        <option value="manager">Manager</option>
                    </select>
                    <p>Password</p>
                    <input type="text" placeholder="Password..." name="password" id="password" required/>
                    <div class="buttons">
                        <button class="register-button" id="register-button" type="submit">Register</button>
                    </div>
                </form>
            </div>
        <% } %>
</body>
</html>