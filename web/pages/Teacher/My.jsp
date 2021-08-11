<%@ page import="pojo.String" %><%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/7/26
  Time: 9:37 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师首页</title>
    <!--    基础路径-->
    <base href="../../">
    <meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel="stylesheet" href="static/css/card-style.css">
</head>
<body>
    <%@include file="headleader.jsp"%>
    <%--从session中获得user    --%>

    <%
        String loginUser=(String)request.getSession().getAttribute("User");
    %>
    <h3>欢迎你登陆！<%=loginUser.getUsername()%></h3>
    <main class="page-content">
        <div class="card">
            <div class="content">
                <h2 class="title">Mountain View</h2>
                <p class="copy">Check out all of these gorgeous mountain trips with beautiful views of, you guessed it, the mountains</p>
                <button class="btn">View Trips</button>
            </div>
        </div>
        <div class="card">
            <div class="content">
                <h2 class="title">To The Beach</h2>
                <p class="copy">Plan your next beach trip with these fabulous destinations</p>
                <button class="btn">View Trips</button>
            </div>
        </div>
        <div class="card">
            <div class="content">
                <h2 class="title">Desert Destinations</h2>
                <p class="copy">It's the desert you've always dreamed of</p>
                <button class="btn">Book Now</button>
            </div>
        </div>
        <div class="card">
            <div class="content">
                <h2 class="title">Explore The Galaxy</h2>
                <p class="copy">Seriously, straight up, just blast off into outer space today</p>
                <button class="btn">Book Now</button>
            </div>
        </div>
    </main>
</body>
</html>
