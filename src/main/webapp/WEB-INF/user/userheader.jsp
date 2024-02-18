<%@page import="java.util.Objects"%>
<%@page import="beans.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IBid</title>
    <link rel="stylesheet" href="css/myhome.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <div class="top-header">
            <img class="logo" src="images/logo-ibid.png" alt="">
            <div class="search">
                <select name="" id="">
                    <option value="">Category</option>
                    <option value="">item-type</option>
                    <option value="">item-type</option>
                    <option value="">item-type</option>
                </select>
                <input class="search-bar" type="search">
                <button><img class="search-img" src="images/search.png" alt=""></button>
            </div>
            <div class="wishlist">
                <p class="wish">My Wishlist<p>
                <p>0 items</p>
            </div>
        </div>
        <div class="navigation-bar">
            <nav>
                <a href="nav?name=myhome">Shop</a>
                <a href="nav?name=items">My Items</a>
                <a href="nav?name=bids">My Bids</a>
                <a href="nav?name=deals">My Deals</a>
                <a href="nav?name=feedback">Feedback</a>
            </nav>
            <div class="left-side-nav">
                <a href="nav?name=notification"> <img class="notification" src="images/notif.png" alt=""></a>
                <img class="profileimg" id="profilepic"  src="profileimg" >
                <div class="sub-menu" id="sub-menu">
                    <div class="user-info">
                        <img src="profileimg" class="profileimg">
                        <% User user = (User)request.getSession().getAttribute("user");%>
                        <p><%=user.getFirstName()%> <%=user.getLastName()%></p>
                    </div>
                    <a class="user-settings" href="nav?name=profile">
                        <img src="images/material-symbols_settings.png" class="profileimg" >
                        <p class="seti">Edit Profile</p>
                        <p >></p>
                    </a>
                    <a class="user-settings" href="logout">
                        <img src="images/streamline_logout-1-solid.png" class="profileimg" alt="eresystrfgbs">
                        <p class="seti">Log Out</p>
                        <p>></p>
                    </a>
                </div>
            </div>
        </div>
    </header>