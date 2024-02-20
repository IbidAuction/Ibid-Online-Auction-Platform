<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IBid</title>
    <link rel="stylesheet" href="css/items.css" type="text/css">
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
            <div class="sidemenu">
                <button id="1" class="sub-menu-button active-button">Active Auctions</button>
                <button id="2" class="sub-menu-button ">Upcoming</button>
                <button id="3" class="sub-menu-button ">Pending</button>
                <button id="4" class="sub-menu-button ">Add item</button>
            </div>
            <div class="main-part">
                <div class="sub-menu-content active-content" id="1">
                    <table>
                    <thead>
                        <th class="item-col">Title</th>
                        <th class="item-col">Image</th>
                        <th>Starting Price</th>
                        <th>Remaining Time</th>
                        <th>Current Bid</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>value</td>
                            <td><img src="" alt=""></td>
                            <td>value</td>
                            <td>value</td>
                            <td>value</td>
                        </tr>
                    </tbody>
                    </table>
                </div>
                <div class="sub-menu-content" id="2">
                    <table>
                        <thead>
                            <th class="item-col">Title</th>
                            <th class="item-col">Image</th>
                            <th>Initial Price</th>
                            <th>Starts at</th>
                            <th>MinIncrement</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>value</td>
                                <td><img src="" alt=""></td>
                                <td>value</td>
                                <td>value</td>
                                <td>value</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="sub-menu-content" id="3">
                    <table>
                        <thead>
                            <th class="item-col">Title</th>
                            <th class="item-col">Image</th>
                            <th>Initial Price</th>
                            <th>MinIncrement</th>
                            <th>Condition</th>
                            <th>Category</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>value</td>
                                <td><img src="" alt=""></td>
                                <td>value</td>
                                <td>value</td>
                                <td>value</td>
                            </tr>
                        </tbody>
                    </table> 
                </div>
                <div class="sub-menu-content" id="4">
                    <form action="additem" method="post" enctype="multipart/form-data" class="add-item-form">
                        <div class="form-data">
                            <div class="form-input">
                                <label for="title">Title:</label>
                                <input class="inputfield" type="text" name="title" id="title" required>
                            </div>
                            <div class="form-input">
                                <label for="description">Description:</label>
                                <textarea class="inputfield" name="description" id="description" rows="5" required></textarea>
                            </div>
                            <div class="form-input">
                                <label for="itemImage">Item Image:</label>
                                <input class="inputfield" type="file" name="itemImage" id="itemImage" accept="image/*">
                            </div>
                            <div class="form-input">
                                <label for="category">Category:</label>
                                <select class="inputfield" name="category" id="category" required>
                                <option value="Electronics">Electronics</option>
                                <option value="Clothing">Clothing</option>
                                <option value="Books">Books</option>
                                <option value="Toys">Toys</option>
                                <option value="Furniture">Furniture</option>
                                <option value="Sports">Sports</option>
                                <option value="Other">Other</option>
                                </select>
                            </div>
                            <div class="form-input">
                                <label for="itemCondition">Item Condition:</label>
                                <select class="inputfield" name="itemCondition" id="itemCondition" required>
                                <option value="New">New</option>
                                <option value="Used">Used</option>
                                </select>
                            </div>
                        </div>
                        <div class="form data">
                            <div class="form-input">
                                <label for="minIncrement">Bid Increment:</label>
                                <input class="inputfield" type="number" name="minIncrement" id="minIncrement" required>
                            </div>
                            <div class="form-input">
                                <label for="startPrice">Starting Price:</label>
                                <input class="inputfield" type="number" name="startPrice" id="startPrice" required>   
                            </div>
                            <div class="form-input">
                                <div>
                                    <label for="startDate">Start Date:</label>
                                    <input class="inputfield" type="Date" name="startDate" id="startDate" required>   
                                </div>
                                <div>
                                    <label for="startTime">Start Time:</label>
                                    <input class="inputfield" type="Time" name="startTime" id="startTime" required>   
                                </div>
                            </div>
                            <div class="form-input">
                                <div>
                                    <label for="endDate">End Date:</label>
                                    <input class="inputfield" type="Date" name="endDate" id="endDate" required>   
                                </div>
                                <div>
                                    <label for="endTime">End Time:</label>
                                    <input class="inputfield" type="Time" name="endTime" id="endTime" required>   
                                </div>
                            </div>
                 
                        </div>
                        <input  class="add-item" type="submit" value="Submit">
                    </form>  
                </div>
            </div>
    </div>
    </div>
    <jsp:include page="userfooter.jsp"/>
    <script src="js/homeheader.js"></script>
    <script src="js/items.js"></script>
</body>
</html>
</body>
</html>
