<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Objects"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="container">
            <div class="signup-form">
                <h2 class="form-title">Sign up</h2>
                <div class=”alert-danger”>
    				<%= Objects.toString(request.getAttribute("error"), " ")%>
				</div>
                <form method="post" action="registeruser" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="firstname"><img src="images/iconamoon_profile-fill.png"></label>
                        <input type="text" name="firstname" id="firstname" placeholder="First Name" required/>
                    </div>
                    <div class="form-group">
                        <label for="lastname"><img src="images/iconamoon_profile-fill.png"></label>
                        <input type="text" name="lastname" id="lastname" placeholder="Last Name" required/>
                    </div>
                    <div class="form-group">
                        <label for="email"><img src="images/ic_baseline-email.png"></label>
                        <input type="text" name="email" id="email" placeholder="example@xxx.com" required/>
                    </div>
                    <div class="form-group">
                        <label for="phone"><img src="images/ic_baseline-phone.png"></label>
                        <input type="Number" name="phone" id="phone" placeholder="Phone Number" required/>
                    </div>
                    <div class="form-group">
                        <label for="city"><img src="images/arcticons_city-transit.png"></label>
                        <input type="text" name="city" id="city" placeholder="city" required/>
                    </div>
                    <div class="form-group">
                        <label for="region"><img src="images/arcticons_city-transit.png" ></label>
                        <input type="text" name="region" id="region" placeholder="Region" required/>
                    </div>
                    <div class="form-group">
                        <label for="password"><img src="images/mdi_password.png"></label>
                        <input type="password" name="password" id="password" placeholder="Password" required/>
                    </div>
                    <div class="">
                        <label for="image"><img src="images/mdi_image-outline.png"></label>
                        <input type="file" name="image" id="image"/>
                    </div>
                    <div class="form-button">
                        <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                    </div>
                </form>
            </div>
            <div class="signup-image">
                <img src="images/logo-ibid.png" alt="sing up image">
                <a href="signin" class="link">I am already member</a>
            </div>
    </div>
    
</body>
</html>