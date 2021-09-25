<%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/9/22
  Time: 6:45 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <base href="../../">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <title>学情监控</title>
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <link rel="stylesheet" href="static/css/style-fornav.css">
    <%--    vue包导入--%>
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
    <!--    vue 路由功能导入-->
    <script src="https://cdn.staticfile.org/vue-router/2.7.0/vue-router.min.js"></script>
</head>
<body>
<%
    User StudentUser=(User)request.getSession().getAttribute("User");
%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="http://47.94.108.20:8080/BuptCreationEE/pages/Student/My.jsp" disabled="disabled" class="navbar-brand">智慧英语协同写作教师端</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="http://47.94.108.20:8080/BuptCreationEE/pages/Teacher/My.jsp">我的</a>
                </li>
                <li>
                    <a href="http://47.94.108.20:8082/teacherpage?name=<%=StudentUser.getUsername()%>">任务发布</a>
                </li>
                <li>
                    <a href="http://47.94.108.20:8080/BuptCreationEE/pages/Teacher/DataController.jsp">学情监控</a>
                </li>
                <li>
                    <a href="http://47.94.108.20:8080/BuptCreationEE/pages/Teacher/Group.jsp">小组管理</a>
                </li>
                <li>
                    <a href="http://47.94.108.20:8080/BuptCreationEE/pages/Teacher/Showblog.jsp">文章浏览</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div id="wrapper" style="top:6%">
    <div class="overlay" style="top:6%"></div>

    <!-- Sidebar -->
    <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation" style="top:6%">
        <ul class="nav sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    数据控制
                </a>
            </li>
            <li>
                <a href="pages/Teacher/DataController.jsp#/pageManage"><i class="fa fa-fw fa-home"></i>任务管控</a>
            </li>
            <li>
                <a href="pages/Teacher/DataController.jsp#/Timeline"><i class="fa fa-fw fa-folder"></i> 修改/时间轴</a>
            </li>
            <li>
                <a href="pages/Teacher/DataController.jsp#/Talkcount"><i class="fa fa-fw fa-file-o"></i> 交谈次数</a>
            </li>
            <li>
                <a href="pages/Teacher/DataController.jsp#/Logincount"><i class="fa fa-fw fa-cog"></i>登陆次数</a>
            </li>
<%--            <li class="dropdown">--%>
<%--                <a href="pages/Teacher/DataController.jsp#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-plus"></i> Dropdown <span class="caret"></span></a>--%>
<%--                <ul class="dropdown-menu" role="menu">--%>
<%--                    <li class="dropdown-header">Dropdown heading</li>--%>
<%--                    <li><a href="#">Action</a></li>--%>
<%--                    <li><a href="#">Another action</a></li>--%>
<%--                    <li><a href="#">Something else here</a></li>--%>
<%--                    <li><a href="#">Separated link</a></li>--%>
<%--                    <li><a href="#">One more separated link</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>
            <li>
                <a href="pages/Teacher/DataController.jsp#/Talknet"><i class="fa fa-fw fa-bank"></i> 关系网络</a>
            </li>
<%--            <li>--%>
<%--                <a href="#"><i class="fa fa-fw fa-dropbox"></i> Page 5</a>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <a href="#"><i class="fa fa-fw fa-twitter"></i> Last page</a>--%>
<%--            </li>--%>
        </ul>
    </nav>
    <!-- /#sidebar-wrapper -->
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas" style="top:6%">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
        </button>
        <div class="container" style="width: 90%;height: 100%">
            <div id="app">
                <router-view id="mainiframe"></router-view>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->
<!--教师页面模版-->
<template id="pageManage">
    <div class="pageManage">
        <iframe width="100%" height="700px" src="pages/Teacher/pageManage.jsp"  frameborder="0" scrolling="auto"></iframe>
    </div>
</template>
<!--时间轴模版-->
<template id="Timeline">
    <div class="Timeline">
        <iframe width="100%" height="700px" src="http://localhost:8082/Timeline"  frameborder="0" scrolling="auto"></iframe>
    </div>
</template>
<!--教师页面模版-->
<template id="Talknet">
    <div class="Talknet">
        <iframe  width="100%" height="700px" src="http://localhost:8082/Talknet"  frameborder="0" scrolling="auto"></iframe>
    </div>
</template>
<!--教师页面模版-->
<template id="Talkcount">
    <div class="Talkcount">
        <iframe  width="100%" height="700px" src="http://localhost:8082/Talkcount"  frameborder="0" scrolling="auto"></iframe>
    </div>
</template>
<!--教师页面模版-->
<template id="Logincount">
    <div class="Logincount">
        <iframe width="100%" height="700px" src="http://localhost:8082/Logincount"  frameborder="0" scrolling="auto"></iframe>
    </div>
</template>
<%--路由跳转程序--%>
<script>
    //1.局部定义组件
    const pageManage = {
        template:"#pageManage"
    };
    const Talknet = {
        template:"#Talknet"
    };
    const Timeline = {
        template:"#Timeline"
    };
    const Talkcount = {
        template:"#Talkcount"
    };
    const Logincount = {
        template:"#Logincount"
    };
    //2.数组定义切换规则，数组中的一个对象就是一个规则,前一个是hash 后一个组件
    const routes=[
        {
            path:'/pageManage',
            component:pageManage,
        },
        {
            path:'/Timeline',
            component:Timeline,
        },
        {
            path:'/Logincount',
            component:Logincount,
        },
        {
            path:'/Talknet',
            component:Talknet,
        },
        {
            path:'/Talkcount',
            component:Talkcount,
        },
        {path:'/',redirect:'/pageManage'},

    ]

    //3.根据规则创建对象
    const router=new VueRouter({
        routes:routes,
        linkActiveClass: ""
    });
    let vue = new Vue({
        el:'#app',
        //4.将对象绑定到vue实例上，然后通过hashi就可以局部路由了
        router:router,
        //专门用于定义局部组件的
        components:{
            pageManage:pageManage,
            Talkcount:Talkcount,
            Talknet:Talknet,
            Timeline:Timeline,
            Logincount:Logincount
        }

    })
</script>
<script src="static/script/bootstrap-fornav.min.js"></script>
<script src="static/script/jquery-1.8.3-fornav.min.js"></script>
<script type="text/javascript">
    function changeFrameHeight(){
        var ifm= document.getElementById("mainiframe");
        ifm.height=document.documentElement.clientHeight-56;
    }
    window.onresize=function(){ changeFrameHeight();}
    $(document).ready(function () {
        changeFrameHeight();
        var trigger = $('.hamburger'),
            overlay = $('.overlay'),
            isClosed = false;

        trigger.click(function () {
            hamburger_cross();
        });
        function hamburger_cross() {

            if (isClosed == true) {
                overlay.hide();
                trigger.removeClass('is-open');
                trigger.addClass('is-closed');
                isClosed = false;
            } else {
                overlay.show();
                trigger.removeClass('is-closed');
                trigger.addClass('is-open');
                isClosed = true;
            }
        }

        $('[data-toggle="offcanvas"]').click(function () {
            $('#wrapper').toggleClass('toggled');
        });
    });
</script>
</body>
</html>