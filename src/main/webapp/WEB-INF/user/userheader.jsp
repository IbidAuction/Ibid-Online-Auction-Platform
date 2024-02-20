<%@page import="java.util.Objects"%>
<%@page import="beans.User"%>
<header>
        <div class="top-header">
            <img class="logo" src="images/logo-ibid.png" alt="">
            <div class="search">
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
                <a href="nav?name=myhome" id="nav-1" >Shop</a>
                <a href="nav?name=items" id="nav-2">My Items</a>
                <a href="nav?name=bids" id="nav-3">My Bids</a>
                <a href="nav?name=deals" id="nav-4">My Deals</a>
                <a href="nav?name=feedback" id="nav-5">Feedback</a>
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