<%@ page import="pojo.User" %><%--
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
</head>
<body>
    <%@include file="headleader.jsp"%>
    <%--从session中获得user    --%>

    <%
        User loginUser=(User)request.getSession().getAttribute("User");
    %>
    <h3>欢迎你登陆！<%=loginUser.getUsername()%></h3>
</body>
</html>
