<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IBid</title>
    <link rel="stylesheet" href="css/myhome.css" type="text/css">
    <link rel="stylesheet" href="css/homeheaderfooter.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <jsp:include page="userheader.jsp"/>
    <hr>
    <div class="content-wrap">
         <div class="content">
            <div class="sidebar">
                <div class="sidebar-element">
                    <p class="sidebar-title">Condition</p>
                    <div class="list condition">
                        <button class="new active"> New</button>
                        <button class="used "> Used</button>
                    </div>
                </div>
                <div class="sidebar-element">
                    <p class="sidebar-title">Catagories</p>
                    <div class="list">
                        <button class="active">Category</button>
                        <button class="">Category</button>
                        <button class="">Category</button>
                        <button class="">Category</button>
                        <button class="">Category</button>
                        <button class="">Category</button>
                        <button class="">Category</button>
                    </div>
                </div>
            </div>
            <div class="product-container">
                <c:forEach var="item" items="${items}">
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
                        <p class="item-title">"${item.title}"</p>
                        <p class="discription">Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque, assumenda dolore in vel nemo sunt reiciendis</p>
                    </div>
                    <p class="bid-current">Current Bid: <span>$20</span></p>
                    <a href="#" class="card-link"></a>
                    <button class="add-to-wishlist"><img src="images/add-to-wish.png" alt=""></button>
                </div>
                </c:forEach>
            </div>
         </div>
    </div>
    <jsp:include page="userfooter.jsp"></jsp:include>
    <script src="js/homeheader.js"></script>
    <script src="js/myhome.js"></script>
</body>
</html>
</body>
</html>
