<%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/7/26
  Time: 8:17 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--动态包含 page属性指定要包含的页面信息
动态包含也能像静态包含一样把被包含的内容执行输出到包含的位置

1.动态包含会把包含的jsp页面也翻译成为java代码
2.动态包含底层代码则去调用被包含的jsp去执行输出
3.动态包含还可以传递参数
--%>
    <jsp:include page="Addblog.jsp"></jsp:include>
        <h1>头部信息</h1>
<%--请求转发标签
他的功能就是请求转发
page设置路径

--%>
        <jsp:forward page="footer.jsp"></jsp:forward>
        <h2>主页信息</h2>
<%--1.静态包含其实是把被包含的代码拷贝到对应位置输出        --%>
        <%@include file="footer.jsp"%>
</body>
</html>
