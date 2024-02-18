<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="userheader.jsp"></jsp:include>
    <hr>
    <div class="content-wrap active" id="1">
         <div class="content">
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
    <script src="js/myhome.js"></script>
</body>
</html>
