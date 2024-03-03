<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/adminsignin.css">
</head>
<body>
    <form action="admintohome" method=POST>
        <div class="header">
                <p class="company"><img src="images/bid-up-favicon-black.png" class="logo"></p>
                <button class="buy-button" type="submit">Buy now</button>
        </div>
    </form>


    <div class="Login-div">
        <div class="login-access">
            <p class="access-text">ACCESS YOUR ACCOUNT</p>
        </div>
        <form action="adminsignin" method="POST">
            <div class="login-content">
                <p class="email">Email <span style="color: rgb(241, 59, 59);">&ast;</span></p>
                <input type="text"  class="login-text" id="login-email" name = "login-email"/>
                <p class="password">Password <span style="color: rgb(241, 59, 59);">&ast;</span></p>
                <div class="password-container">
                    <input type="password"  class="login-password" id="login-password" name = "login-password"/>
                    <button type="button"  class="toggle-password" onclick="togglePasswordVisibility()" style="color: rgb(136, 133, 133);">&#128065</button>
                </div>
            </div>

            <div class="login-button-div">
                <button type="submit" class="Login">LOG IN</button>
                <p>
                    <a href="" id="forget" class="forget-link">Forgot Password?</a>
                </p>
            </div>
        </form>
    </div>

    <script>
        const linkelem = document.getElementById("forget");
        linkelem.addEventListener('click',function(event){
            alert("Check your email for recovery password!")
        });

        function togglePasswordVisibility(){
            const butelem = document.getElementById("login-password");
            if (butelem.type == "password" && butelem.value.trim() !== ""){
                butelem.type = "text";
            } else{
                butelem.type = "password";
            }
        }
    </script>
</body>
</html>