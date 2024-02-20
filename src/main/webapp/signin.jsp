<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Objects"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ibid</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="container">
            <div class="signup-form">
                <h2 class="form-title">Sign in</h2>
                <% String errorMessage = (String) request.getSession().getAttribute("error"); %>
                <% if (errorMessage != null && !errorMessage.isEmpty()) { %>
                    <p style="color: red;"><%= errorMessage %></p>
                    <% request.getSession().removeAttribute("error");%>
                <% } %>
                <form method="POST" action="signinuser">
                    <div class="form-group">
                        <label for="email"><img src="images/ic_baseline-email.png"></label>
                        <input type="text" name="email" id="email" placeholder="example@xxx.com" required/>
                    </div>
                   
                    <div class="form-group">
                        <label for="password"><img src="images/mdi_password.png"></label>
                        <input type="password" name="password" id="password" placeholder="Password" required/>
                    </div>
                    <div class="form-button">
                        <input type="submit" name="signup" id="signup" class="form-submit" value="Sign in"/>
                    </div>
                </form>
            </div>
            <div class="signup-image">
                <img src="images/logo-ibid.png" alt="sing in image">
                <a href="register" class="link">Create new account</a>
            </div>
    </div>
    
</body>
</html>