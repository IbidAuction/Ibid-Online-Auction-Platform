<%@page import="service.ItemDAO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.User"%>
<%@page import="jakarta.servlet.http.HttpServlet.*"%>
<%@page import="beans.Admin"%>
<%@page import="service.AdminDAO"%>
<%@page import="beans.Item"%>
<%@page import="jakarta.servlet.http.HttpSession"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/useradmindash.css">
    <link rel="stylesheet" href="css/listuser.css">
    <script src="js/d3.js"></script>
    <script src="js/plot.js"></script>
    <title>Item Admin</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
    String check = (String) checksession.getAttribute("AdminEmail");
    if (check == null || check.equals("")){ %>
        <h1>Page not found</h1> 
    <% } else { %>
        <jsp:include page="ItemAdminheader.jsp" />
        <% ItemDAO currDAO = new ItemDAO();
            List<Item>all = currDAO.getAll();
            Integer pending = 0;
            Integer approved  = 0;
            Integer rejected = 0;
            Integer Total = 0;
            for (Item it: all){
                if(it.getItemState().equals("approved")){
                    approved += 1;
                }else if (it.getItemState().equals("pending")){
                    pending += 1;
                }else{
                    rejected += 1;
                }
            }
            Total = approved + pending + rejected;
        %>
        <div class="container">
            <div class="topics">
                <h1 style="color: rgb(38, 149, 255);
                            font-weight: bold;
                            display: block;
                            margin-bottom: 50px;
                            font-family: Arial, Helvetica, sans-serif;">WELCOME !</h1>

                <h2 style="color: rgb(38, 149, 255);
                            font-weight: bold;
                            display: block;
                            margin-bottom: 50px;
                            font-family: Arial, Helvetica, sans-serif;">ITEM ANALYTICS: </h2>
                

                <div class = "dash-analytics" style="grid-column-gap: 150px;">

                    <div class="count-design" style = "width:200px;">
                        <img src="images/list (4).png"/>
                        <p> <%=Total%> Total Items </p>
                    </div>
                    <div class="count-design" style = "width:200px;">
                        <img src="images/verified.png"/>
                        <p> <%=approved%> Approved Items</p>
                    </div>

                    <div class = "count-design" style = "width:200px;">
                        <img src="images/cross (1).png"/>
                        <p> <%=rejected%> Rejected Items<p>
                    </div>

                    <div class = "count-design" style = "width:200px;">
                        <img src="images/wall-clock (4).png"/>
                        <p> <%=pending%> Pending Items</p>
                    </div>
                </div>

            </div>
            <div class = "graph-container">
                <div class="pie-chart">
                    <svg width="500" height="400"></svg>
                    <script>
                        var svg = d3.select("svg"),
                            width = svg.attr("width"),
                            height = svg.attr("height"),
                            radius = 200;

                        var data = [
                                    { name: "Approved", share: <%=approved%>, color: "rgb(38, 149, 255)" },       
                                    { name: "Pending", share: <%=pending%>, color: "rgb(255, 174, 38)" }, 
                                    { name: "Rejected", share: <%=rejected%>, color: "rgb(220, 0, 0, 0.8)" }      
                                    ];

                        var ordScale = d3.scaleOrdinal()
                                            .domain(data.map(function(d) { return d.name; }))
                                            .range(data.map(function(d) { return d.color; }));
                        var g = svg.append("g")
                                    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");

                        var pie = d3.pie().value(function(d) {
                                return d.share; 
                            });

                        var arc = g.selectAll("arc")
                                    .data(pie(data))
                                    .enter();

                        var path = d3.arc()
                                        .outerRadius(radius)
                                        .innerRadius(0);

                        arc.append("path")
                            .attr("d", path)
                            .attr("fill", function(d) { return ordScale(d.data.name); });

                        var label = d3.arc()
                                    .outerRadius(radius)
                                    .innerRadius(0);
                            
                        arc.append("text")
                            .attr("transform", function(d) { 
                                    return "translate(" + label.centroid(d) + ")"; 
                            })
                            .text(function(d) { return d.data.name; })
                            .style("font-family", "arial")
                            .style("font-size", 18)
                            .style("fill", "Black")
                            .style("font-weight", "bold");
                    </script>
                </div>

                <div class = "bargraph">
                    <script src="js/d3.js"></script>
                    <script>
                        var margin = {top: 20, right : 20, bottom: 30, left: 40},
                            width = 900 - margin.left - margin.right,
                            height = 500 - margin.top - margin.bottom;
                        
                        var x = d3.scaleBand()
                                    .range([0, width])
                                    .padding(0.5);
                        var y = d3.scaleLinear()
                                    .range([height, 0]);
                        
                        var svg = d3.select(".bargraph").append("svg")
                                .attr("width", width + margin.left + margin.right)
                                .attr("height", height + margin.top + margin.bottom)
                            .append("g")
                                .attr("transform", 
                                    "translate(" + margin.left + "," + margin.top + ")" )
                        data = [
                                    { name: "Approved", share: <%=approved%>, color: "rgb(38, 149, 255)" },       
                                    { name: "Pending", share: <%=pending%>, color: "rgb(255, 174, 38)" }, 
                                    { name: "Rejected", share: <%=rejected%>, color: "rgb(220, 0, 0, 0.8)" } 
                                ];
                        data.forEach(function(d) {
                            d.share = +d.share;
                        });

                        x.domain(data.map(function(d) { return d.name; }));
                        y.domain([0, d3.max(data, function(d) { return d.share; })]);

                        svg.selectAll(".bar")
                                .data(data)
                            .enter().append("rect")
                                .attr("class", "bar")
                                .attr("x", function(d) {return x(d.name);})
                                .attr("width", x.bandwidth())
                                .attr("y", function(d) {return y(d.share);})
                                .attr("height", function(d) {return height - y(d.share);})
                                .attr("fill", "steelblue"); 
                        svg.selectAll(".bar-label")
                                .data(data)
                            .enter().append("text")
                                .attr("class", "bar-label")
                                .attr("x", function(d) { return x(d.name) + x.bandwidth() / 2; })
                                .attr("y", function(d) { return y(d.share) - 5; })
                                .attr("text-anchor", "middle")
                                .text(function(d) { return d.share; })
                                .style("font-family", "Arial")
                                .style("font-size", "12px")
                                .style("fill", "black");
                    svg.append("g")
                            .attr("transform", "translate(0," + height + ")")
                            .call(d3.axisBottom(x));
                    </script>
                </div>
            </div>
        </div>
    <% } %> 
</body>
</html>