<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/7/26
  Time: 8:21 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:v-on="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>实现博客</title>
    <!--    基础路径-->
    <base href="../../">
    <!--    vue-基础包导入-->
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
    <!--    vue 路由功能导入-->
    <script src="https://cdn.staticfile.org/vue-router/2.7.0/vue-router.min.js"></script>
    <!--    提示区样式导入-->
    <link rel="stylesheet" href="static/css/style-text-animation.css">
    <!-- 雪落背景-->
    <link rel="stylesheet" href="static/css/style-winter.css">
</head>
<body >

<%@include file="headleader.jsp"%>
<!--雪落-->
<div class="sky">
    <div class="deep_sky"></div>
</div>
<div class="c1">
    <div class="cloud"></div>
</div>
<div class="c2">
    <div class="cloud"></div>
</div>
<div class="c3">
    <div class="cloud"></div>
</div>
<div class="windmill">
    <div class="tower"></div>
    <div class="t1"></div>
    <div class="t2"></div>
    <div class="blade">
        <div class="windblade"></div>
        <div class="windblade windblade2"></div>
        <div class="windblade windblade3"></div>
        <div class="windblade windblade4"></div>
    </div>
</div>
<div class="allsnows">
    <div class="snow1"></div>
    <div class="snow2"></div>
    <div class="snow3"></div>
    <div class="snow4"></div>
    <div class="snow5"></div>
    <div class="snow6"></div>
    <div class="snow7"></div>
    <div class="snow8"></div>
    <div class="snow9"></div>
    <div class="snow10"></div>
    <div class="snow11"></div>
    <div class="snow12"></div>
    <div class="snow13"></div>
    <div class="snow14"></div>
    <div class="snow15"></div>
    <div class="snow16"></div>
    <div class="snow17"></div>
    <div class="snow18"></div>
    <div class="snow19"></div>
    <div class="snow20"></div>
</div>

<!--多人写作关键词提示区-->
<div class="content">
    <div class="content__container">
        <p class="content__container__text">
            key：
        </p>

        <ul class="content__container__list">
            <li class="content__container__list__item">Lihua!</li>
            <li class="content__container__list__item">Vocabulary!</li>
            <li class="content__container__list__item">fluent!</li>
            <li class="content__container__list__item">beautiful!</li>
        </ul>
    </div>
</div>

<%--从session中获得user--%>
<%
    User loginUser=(User)request.getSession().getAttribute("User");
%>
<!--写作部分-->
<div class="app-blog">
    <!--    标题部分-->
    <h2>多人协作内容</h2>
    <!--    文章标题内容编写-->
    <form action="" method="post" id="form" v-if="!blog.submitted">
        <label>文章标题</label>
        <input type="text" name="title" v-model="blog.title" required/>

        <label>文章内容</label>
        <textarea name="content" v-model="blog.content"></textarea>
        <div id="checkboxes">
            <label>Vue.js</label>
            <input name="categories" type="checkbox" value="Vue.js" v-model="blog.categories">
            <label>Node.js</label>
            <input name="categories" type="checkbox" value="Node.js" v-model="blog.categories">
            <label>React.js</label>
            <input name="categories" type="checkbox" value="React.js" v-model="blog.categories">
            <label>Angular4</label>
            <input name="categories" type="checkbox" value="Angular4" v-model="blog.categories">
        </div>

        <!--    动态浏览部分    -->
        <label>作者:</label>
        <select v-model="blog.author">
            <option name="author" v-for="author in authors">
                {{author}}
            </option>
        </select>
        <!--        <input type="submit" value="发布文章" id="sub_btn" />-->
        <button v-on:click.prevent="Post">发布文章</button>
    </form>

    <h3 id="ok" v-if="blog.submitted">您的文章发布成功！</h3>
    <hr>
    <div id="preview">
        <h3>文章总览</h3>
        <p>文章标题:{{blog.title}}</p>
        <p>文章内容:</p>
        <p>{{blog.content}}</p>
        <p>文章类别</p>
        <ul>
            <li v-for="category in blog.categories">
                {{category}}
            </li>
        </ul>
        <p>作者:{{blog.author}}</p>
    </div>
</div>

<!--vue功能-->
<script type="text/javascript">
    var vm = new Vue({
        el: ".app-blog" ,
        data:{
            blog:{
                title:"hi",
                content:"你好",
                categories:[],
                author:"<%=loginUser.getUsername()%>",
                submitted:false,
                studentNo: "<%=loginUser.getStudentNo()%>"
            },
            authors:["Hemiah","Hemry","Buky"]
        },
        methods:{
            Post:function(){
                var article = {title: this.blog.title,content:this.blog.content,author:this.blog.author,studentNo:this.blog.studentNo}
                this.$http.post("addblogsevlet",JSON.stringify(article)).then(function(data){
                    console.log(data);
                    $("#messageDiv").html(data);
                    var json=JSON.parse(data);
                    alert(json.message);
                    this.blog.submitted=true;
                })
            }
        }

    })
</script>



<style>
    #add-blog *{
        box-sizing: border-box;
    }
    #add-blog{
        margin:20px auto;
        max-width:400px;
        padding:20px;

    }
    lable{
        display:block;
        margin:20px 0 10px;
    }
    input[type="text"],textarea,select{
        display:block;
        width:60%;
        padding:8px;
        border-radius: 10px;
    }
    textarea{
        height:200px;
    }
    #checkboxes label{
        display:inline-block;
        margin-top:0;
    }
    #checkboxes input{
        display:inline-block;
        margin-right:10px;
    }

    button{
        display:block;
        margin:20px 0;
        background:#ffe57d;
        color:gray;
        border:0;
        padding: 14px;
        border-radius:20px;
        font-size:18px;
        cursor:pointer;
    }
    #preview{
        padding:10px 20px;
        border:1px dotted #666666;
        margin: 30px 0;
    }
    h3{
        margin-top:10px ;
    }


</style>


</body>
</html>
