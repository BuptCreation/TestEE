<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/8/1
  Time: 3:54 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作品评论</title>
    <%--    基础地址--%>
    <base href="../../">
    <%--    vue包导入--%>
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
    <!--    vue 路由功能导入-->
    <script src="https://cdn.staticfile.org/vue-router/2.7.0/vue-router.min.js"></script>
    <%--    背景--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel="stylesheet" href="static/css/teacher-background-style.css">
</head>
<body>
<%@include file="headleader.jsp"%>
<%--背景--%>
<div id="top-image"></div>
<div id="app">
    <%
        User loginUser=(User)request.getSession().getAttribute("User");
    %>
<div  v-for="blog in blogs">
    <div class="blog" >
    <h1>{{blog.title}}</h1>
    <h4>{{blog.content|snippet}}</h4>
    <h4>关键词:编使劲编</h4>
    <h2 style="float: right">作者:{{blog.author}}</h2>
        <button v-on:click="goComment(blog.title,blog.body)">评论</button>
        <br/>
    </div>
</div>

</div>



<script type="text/javascript">
    var vm = new Vue({
        el: "#app" ,
        data:{
            blogs:[]
        },
        methods:{
            goComment(title,body){

                commentblog={title:title,content:body}
                localStorage.setItem('blog',JSON.stringify(commentblog))
                window.location.href="pages/Teacher/Comment.jsp"
            },
            loadComments(){
                // var list = JSON.parse(localStorage.getItem('cmts') || '[]')
                // this.list = list
                this.$http.get("showgroupblogservlet")
                    .then(function (data) {
                        console.log(data);
                        this.blogs = data.body.slice(0,10);

                    })
            }

        },
        created(){
            <%--this.teacherUsername = "<%= loginUser.getUsername()%>"--%>
            <%--// var userName = {teacherUsername: this.teacherUsername }--%>
            <%--// console.log(userName.teacherUsername);--%>
            <%--// this.$http.post("showgroupblogservlet",JSON.stringify(userName));--%>
            this.loadComments()
        }

    })
    //    防止内容过长
    Vue.filter("snippet",function(value){
        if(value)
            return value.slice(0,100)+"..."
    })
</script>
<style>
    .blog{
        width: 55%;
        float: left;
        box-shadow: 10px 10px 5px #888888;
       gap: 20px;
    }
    .
</style>
<%--背景--%>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script  src="static/script/teacher-background-script.js"></script>

</body>
</html>
