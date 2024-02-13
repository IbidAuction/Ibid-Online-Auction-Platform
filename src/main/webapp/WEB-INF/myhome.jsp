<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <a href="">Shop</a>
                <a href="">My Items</a>
                <a href="">My Bids</a>
                <a href="">My Deals</a>
                <a href="">Feedback</a>
            </nav>
            <div class="left-side-nav">
                <img class="notification" src="images/notif.png" alt="">
                <img class="profileimg" id="profilepic"  src="images/pic.jpg" alt="">
                <div class="sub-menu" id="sub-menu">
                    <div class="user-info">
                        <img src="<%= ((User)session.getAttribute("user")).getProfileImage()%>" class="profileimg" alt="eresystrfgbs">
                        <p>Firomsa Assefa</p>
                    </div>
                    <a class="user-settings" href="#">
                        <img src="images/profile-fill.png" class="profileimg" alt="eresystrfgbs">
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
    <hr>
    <main>
        <div class="sidebar">
            <div class="sidebar-element">
                <p class="sidebar-title">Filter by price</p>
                <div class="list">

                </div>
            </div>
            <div class="sidebar-element">
                <p class="sidebar-title">Condition</p>
                <div class="list condition">
                    <label for=""><input type="checkbox"> New</label>
                    <label for=""><input type="checkbox"> Used</label>
                </div>
            </div>
            <div class="sidebar-element">
                <p class="sidebar-title">Product catagories</p>
                <div class="list">
                    <p>Category</p>
                    <p>Category</p>
                    <p>Category</p>
                    <p>Category</p>
                    <p>Category</p>
                    <p>Category</p>
                    <p>Category</p>
                </div>
            </div>
            <div class="sidebar-element">
                <p class="sidebar-title">Sorting</p>
                <div class="list">

                </div>
            </div>
        </div>
        <div class="product-container">
            <div class="product-card">
                <img src="images/laptop.jpg" alt="">
                <div class="time-left">
                    <p class="time-left-title">Time Left</p>
                    <div class="countdown">
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                    </div>
                </div>
                <div class="">
                    <p class="item-title">Title</p>
                    <p class="discription">Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque, assumenda dolore in vel nemo sunt reiciendis</p>
                </div>
                <p class="bid-current">Current Bid: <span>$20</span></p>
                <a href="#" class="card-link"></a>
                <button class="add-to-wishlist"><img src="images/add-to-wish.png" alt=""></button>
            </div>
            <div class="product-card">
                <img src="images/laptop.jpg" alt="">
                <div class="time-left">
                    <p class="time-left-title">Time Left</p>
                    <div class="countdown">
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                    </div>
                </div>
                <div class="">
                    <p class="item-title">Title</p>
                    <p class="discription">Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque, assumenda dolore in vel nemo sunt reiciendis</p>
                </div>
                <p class="bid-current">Current Bid: <span>$20</span></p>
                <a href="#" class="card-link"></a>
                <button class="add-to-wishlist"><img src="images/add-to-wish.png" alt=""></button>
            </div>
            <div class="product-card">
                <img src="images/laptop.jpg" alt="">
                <div class="time-left">
                    <p class="time-left-title">Time Left</p>
                    <div class="countdown">
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                    </div>
                </div>
                <div class="">
                    <p class="item-title">Title</p>
                    <p class="discription">Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque, assumenda dolore in vel nemo sunt reiciendis</p>
                </div>
                <p class="bid-current">Current Bid: <span>$20</span></p>
                <a href="#" class="card-link"></a>
                <button class="add-to-wishlist"><img src="images/add-to-wish.png" alt=""></button>
            </div>
            <div class="product-card">
                <img src="images/laptop.jpg" alt="">
                <div class="time-left">
                    <p class="time-left-title">Time Left</p>
                    <div class="countdown">
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                        <div class="count-var">
                            <p class="time">111</p>
                            <p class="time-range">days</p>
                        </div>
                    </div>
                </div>
                <div class="">
                    <p class="item-title">Title</p>
                    <p class="discription">Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque, assumenda dolore in vel nemo sunt reiciendis</p>
                </div>
                <p class="bid-current">Current Bid: <span>$20</span></p>
                <a href="#" class="card-link"></a>
                <button class="add-to-wishlist"><img src="images/add-to-wish.png" alt=""></button>
            </div>
        </div>
    </main>
    <footer>
        <div class="about-us">
            <div class="details">
                <p class="footer-title">IBID</p>
                <div class="footer-content">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel pariatur non, omnis ullam asperiores similique, sequi, libero soluta sunt aliquam voluptatum in atque. Reiciendis at sapiente aperiam autem, assumenda error?</p>
                </div>
            </div>
            <div class="details">
                <p class="footer-title">Quick Links</p>
                <div class="footer-content">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel pariatur non, omnis ullam asperiores similique, sequi, libero soluta sunt aliquam voluptatum in atque. Reiciendis at sapiente aperiam autem, assumenda error?</p>
                </div>
            </div>
            <div class="details">
                <p class="footer-title">Latest Post</p>
                <div class="footer-content">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel pariatur non, omnis ullam asperiores similique, sequi, libero soluta sunt aliquam voluptatum in atque. Reiciendis at sapiente aperiam autem, assumenda error?</p>
                </div>
            </div>
            <div class="details">
                <p class="footer-title">Contact us</p>
                <div class="footer-content">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel pariatur non, omnis ullam asperiores similique, sequi, libero soluta sunt aliquam voluptatum in atque. Reiciendis at sapiente aperiam autem, assumenda error?</p>
                </div>
            </div>
        </div>
        <div class="copyright">
            <p>mleuwifgewuigibaspjdcweugafps</p>
            <p>asbuigewfgwpeafjbjcao</p>
        </div>
    </footer>
    <script src="js/myhome.js"></script>
</body>
</html>
