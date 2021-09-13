<%@ page import="pojo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/9/11
  Time: 9:59 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    基础地址--%>
    <base href="../../">
    <%--    vue包导入--%>
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
        <!--    vue 路由功能导入-->
        <script src="https://cdn.staticfile.org/vue-router/2.7.0/vue-router.min.js"></script>
    <%-- bootstrap导入   --%>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>数据分析</title>
    <style>
    </style>
</head>
<body>
<%@include file="headleader.jsp"%>
<div id="app">
    <br/>
<%--    <a href="pages/Teacher/DataAnalyis.jsp#/one">第一个页面</a>--%>
<%--    <a href="pages/Teacher/DataAnalyis.jsp#/two">第二个页面</a>--%>
    <%--用routerlink不需要写#，且可通过tag来进行标签渲染的指定--%>

    <nav class="navbar-inverse  visible-lg visible-md" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">我的课程</a>
            </div>
            <div>
                <ul class="nav navbar-nav nav-stacked">
                    <li class="active"><a href="#">iOS</a></li>
                    <li><a href="#">SVN</a></li>
                    <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Java</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <%--尝试用竖形排版    --%>
    <p>任务分析</p>
    <ul class="nav  nav-pills nav-stacked" style="width: 15%">
        <li role="presentation"><router-link to="/one?name=ng&age=20">第一页面</router-link></li>
        <li role="presentation"><router-link to="/two/zs/23" >第二页面</router-link></li>
    </ul>
    <router-view></router-view>


    <%--测试用导航栏    --%>
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
                        <a href="http://47.94.108.20:8080/BuptCreationEE/pages/Teacher/Group.jsp">小组管理</a>
                    </li>
                    <li>
                        <a href="http://47.94.108.20:8080/BuptCreationEE/pages/Teacher/Showblog.jsp">文章浏览</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<template id="one">
    <div class="onepage">
        <p>我是第一个界面</p>
        <router-link to="/one/onesub">第一子页面</router-link>
        <router-link to="/one/twosub">第二子页面</router-link>
        <router-view></router-view>
    </div>
</template>
<template id="two">
    <div class="twopage">
        <p>我是第二个界面</p>
    </div>
</template>
<template id="onesub">
    <div class="onesubpage">
        <p>我是第一个子界面</p>
    </div>
</template>
<template id="twosub">
    <div class="twosubpage">
      <iframe src="pages/test/ChatRoom.jsp"></iframe>
    </div>
</template>
<script>
    //1.局部定义组件
    const subone={
        template:"#onesub"
    };
    const subtwo={
        template:"#twosub"
    }
    const one = {
        template:"#one",
        //第一种传递方式
        created:function(){
            console.log(this.$route)
            console.log(this.$route.query.name)
        }
    };
    const two = {
        template:"#two",
        //第二种传递方法
        created:function(){
            console.log(this.$route),
                console.log(this.$route.params.name)
        }

    };
    //2.数组定义切换规则，数组中的一个对象就是一个规则,前一个是hash 后一个组件
    const routes=[
        //配置子路由
        {
            path:'/one',
            component:one,
            children:[
            //    写子路由
                {
                    path:"onesub",component:subone
                },
                {
                    path: "twosub",component: subtwo
                }
            ]
        },
        {path:'/',redirect:'/one'},
        {path:'/one',component:one},
        {path:'/two/:name/:age',component: two}
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
            one:one,
            two:two
        }

    })
</script>








</body>
</html>
