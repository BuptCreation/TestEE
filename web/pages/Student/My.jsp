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
    <title>学生首页</title>
    <!--    基础路径-->
    <base href="../../">
    <!--提示表单样式CSS  -->
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
    <%--从session中获得user    --%>

    <%
        String loginUser=(String)request.getSession().getAttribute("User");
    %>
    <!--  -->
    <section class="intro">
        <div class="container">
            <h1><!--  -->
                <section class="intro">
                    <div class="container">
                        <h1>欢迎你登陆！<%=loginUser.getUsername()%> 查看你的最新消息吧&darr;</h1>
                    </div>
                </section>

                <section class="timeline">
                    <ul class="messages">
                        <li>
                            <div>
                                <time>2005</time> In mattis elit vitae odio posuere, nec maximus massa varius. Suspendisse varius volutpat mattis. Vestibulum id magna est.
                                <button onclick=goComment("2005",)>评论</button>
                            </div>
                        </li>
                    </ul>
                </section>
                &darr;</h1>
        </div>
    </section>

<script>
    var messages;
    function goComment(title,body,permission){
        console.log("点击事件触发")
        commentblog={title:title,content:body,permission:permission}
        localStorage.setItem('blog',JSON.stringify(commentblog))
        window.location.href="pages/Student/Comment.jsp"
    }
    $(function(){
        $.getJSON("shownewsservlet",function (data) {
            $.each(data,function (i,message) {
                console.log(message);
                if (message.type=="comment") {
                    var str = " <li>\n" +
                        "                            <div>\n" +
                        "                               "+"<time><span  class=\"label label-info\">作品互评</span></time>"+"您已经被分配到评论文章{"+message.title + "}点击按钮进行评论 \n"+"<br/>"+
                        "<button class=\"btn btn-info btn-lg\" onclick='goComment(\""+message.title+"\",\""+message.content+"\",\""+"true"+"\")'><span class=\"glyphicon glyphicon-pencil\"></span>评论</button>"+
                        "                            </div>\n" +
                        "       </li>";
                    $(".messages").append(str);
                }else if (message.type=="评论我"){
                    var str = " <li>\n" +
                        "                            <div>\n" +
                        "                               "+"<time><span  class=\"label label-success\">作品互评</span></time>"+"您已经被分配到评论文章{"+message.title + "}点击按钮进行评论 \n"+"<br/>"+
                        "<button class=\"btn btn-info btn-lg\" onclick='goComment(\""+message.title+"\",\""+message.content+"\",\""+"true"+"\")'><span class=\"glyphicon glyphicon-pencil\"></span>评论</button>"+
                        "                            </div>\n" +
                        "       </li>";
                    $(".messages").append(str);
                }
            })
        }).then( function () {
            "use strict";

            // define variables
            var items = document.querySelectorAll(".timeline li");

            // check if an element is in viewport
            // http://stackoverflow.com/questions/123999/how-to-tell-if-a-dom-element-is-visible-in-the-current-viewport
            function isElementInViewport(el) {
                var rect = el.getBoundingClientRect();
                return (
                    rect.top >= 0 &&
                    rect.left >= 0 &&
                    rect.bottom <=
                    (window.innerHeight || document.documentElement.clientHeight) &&
                    rect.right <= (window.innerWidth || document.documentElement.clientWidth)
                );
            }

            function callbackFunc() {
                for (var i = 0; i < items.length; i++) {
                    if (isElementInViewport(items[i])) {
                        items[i].classList.add("in-view");
                    }
                }
            }

            // listen for events
            window.addEventListener("load", callbackFunc);
            window.addEventListener("resize", callbackFunc);
            window.addEventListener("scroll", callbackFunc);
        })
    })
</script>
    <!-- 提示表单样式js-->
<%-- --%>
</body>

</html>
