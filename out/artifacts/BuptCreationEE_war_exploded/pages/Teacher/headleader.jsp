<%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/7/26
  Time: 9:27 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--    基础路径-->
    <base href="../../">
    <!--    引入bootstrap相应样式文件-->
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <%--引入jquery    --%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<!-- 导航栏区域   -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">智慧英语协同写作教师端</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li ><a href="pages/Teacher/My.jsp">我的</a></li>
                <li ><a href="pages/Teacher/Postblog.jsp">任务发布</a></li>
                <li ><a href="pages/Teacher/Showblog.jsp">作品评论</a></li>
                <li ><a href="pages/Teacher/Group.jsp">小组管理</a></li>
            </ul>
        </div>
    </div>
</nav>
<br/>
<br/>
<br/>
<%--动态显示高亮--%>
<script>
    $('.nav').find('a').each(function () {
        if (this.href == document.location.href || document.location.href.search(this.href) >= 0) {
            $(this).parent().addClass('active'); // this.className = 'active';
        }
    });
</script>
</body>
</html>
