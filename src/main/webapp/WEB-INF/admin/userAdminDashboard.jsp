<%@page import="service.UserDAO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.User"%>
<%@page import="jakarta.servlet.http.HttpServlet.*"%>
<%@page import="beans.Admin"%>
<%@page import="service.AdminDAO"%>
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
    <title>User Admin Dashboard</title>
</head>
<body>
    <% HttpSession checksession = request.getSession(false);
    String check = (String) checksession.getAttribute("AdminEmail");
    if (check == null || check.equals("")){ %>
        <h1>Page not found</h1> 
    <% } else { %>
        <jsp:include page="adminheader.jsp" />
        <% 
            UserDAO currDAO = new UserDAO();
            List<User>curr = currDAO.getAll();
            Integer Total = 0;
            Integer Active = 0;
            Integer banned = 0;
            Integer suspended = 0;

            for (User l : curr){
                if (l.getUserStatus().equals("active")){
                    Active += 1;
                } else if (l.getUserStatus().equals("suspended")){
                    suspended += 1;
                } else{
                    banned += 1;
                }
                Total += 1;
            }
            %>
        <div class="container">
            <div class="topics">
                <h1 style="color: rgb(38, 149, 255);
                            font-weight: bold;
                            display: block;
                            margin-bottom: 100px;
                            font-family: Arial, Helvetica, sans-serif;">WELCOME !</h1>

                <h2 style="font-weight: bold;
                            display: block;
                            margin-bottom: 50px;
                            font-family: Arial, Helvetica, sans-serif;">USER ANALYTICS: </h2>

                <p> <%=Total%> Total Users </p>
                <p> <%=Active%> Active Users </p>
                <p> <%=banned%> Banned Users <p>
                <p> <%=suspended%> Suspended Users</p>
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
                                    { name: "Active", share: <%=Active%>, color: "rgb(38, 149, 255)" },       
                                    { name: "Suspended", share: <%=suspended%>, color: "rgb(255, 174, 38)" }, 
                                    { name: "Banned", share: <%=banned%>, color: "rgb(220, 0, 0, 0.8)" }      
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
                                    { name: "Active", share: <%=Active%>, color: "rgb(38, 149, 255)" },      
                                    { name: "Suspended", share: <%=suspended%>, color: "rgb(255, 174, 38)" }, 
                                    { name: "Banned", share: <%=banned%>, color: "rgb(220, 0, 0, 0.8)" } 
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