<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/11/1
  Time: 8:06 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--    基础路径-->
    <base href="../../">
    <title>协同写作</title>

    <link rel="stylesheet" href="static/css/prompt-style.css">
    <!--    vue-基础包导入-->
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
    <%--bootstrap导入    --%>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<%@include file="headleader.jsp"%>
<iframe style="width: 100%;height: 100%;overflow-y: scroll" src="http://47.94.108.20:9001?name=<%=StudentUser.getUsername()%>"></iframe>
<%@include file="../Public/footer.jsp"%>
</body>
</html>
