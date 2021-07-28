<%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/7/27
  Time: 11:28 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    基础地址--%>
    <base href="../../">
    <!--    vue-基础包导入-->
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
<%--    表单样式加入--%>
    <link href='https://fonts.googleapis.com/css?family=Days+One' rel='stylesheet' type='text/css'><link rel="stylesheet" href="static/css/list-style.css">
<%--    雪落背景加入--%>
    <link rel="stylesheet" href="static/css/snow-style.css">
    <title>任务发布</title>
<%--    keyword card--%>
    <style>
        keyword{
            display: flex;

        }
        div.polaroid {
            width: 250px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            text-align: center;
            padding: 10px;
        }

        div.keyword {
            background-color: #ecf0f1;
            padding: 10px;
        }
    </style>
</head>
<body>
<%@include file="headleader.jsp"%>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="snow"></div>
<div class="app-post">
<%-- 以上为背景   --%>
    <h2>协同写作任务发布</h2>
<%--    教师编辑，发布端--%>
    <form method="post" id="form" v-if="!blog.submitted">
        <label >文章标题</label>
        <input type="text" name="title" v-model="blog.title" required/>
    <br/>
        <label>写作指导</label>
        <textarea name="guide" v-model="blog.guide"></textarea>
    <br/>
        <label>写作关键词</label>
<%--        <select v-model="blog.keyword">--%>
<%--        <option name="keyword" v-for="keyword in keywords">--%>
<%--            {{keyword}}--%>
<%--        </option>--%>
<%--        </select>--%>
    <br/>
<%--      关键词展示样式  --%>
        <keyword>
        <div class="polaroid">
            <img src="static/img/challenge.jpeg" alt="Norway" style="width:100%;height: 60%">
            <div class="keyword">
                Challenge<input type="radio" checked="checked" name="keyword" value="Challenge" v-model="blog.keyword"/>
            </div>
        </div>
        <div class="polaroid">
            <img src="static/img/funny.jpeg" alt="Norway" style="width:100%;height: 60%">
            <div class="keyword">
                Funny<input type="radio" checked="checked" name="keyword" value="Funny" v-model="blog.keyword"/>
            </div>
        </div>
            <div class="polaroid">
                <img src="static/img/trying.jpeg" alt="Norway" style="width:100%;height: 60% ">
                <div class="keyword">
                    Trying<input type="radio" checked="checked" name="keyword" value="Trying" v-model="blog.keyword"/>
                </div>
            </div>
            <div class="polaroid">
                <img src="static/img/meaningful.jpeg" alt="Norway" style="width:100%;height: 60%">
                <div class="keyword">
                    Meaningful<input type="radio" checked="checked" name="keyword" value=" Meaningful" v-model="blog.keyword"/>
                </div>
            </div>
        </keyword>
        <br/>
<%--        搜索样式--%>
        <input type="text" v-model="search" placeholder="搜索学生">
<%--    表格样式    --%>
            <dl class="list maki">
                <dt>合作学生:</dt>
                <dd v-for="student,index in filterStudents.slice(0,10)" >
                    <a>{{student.title}}<input  :value="student.title" name="writers" type="checkbox"  v-model="blog.writers"></a>
                </dd>
            </dl>
            <a href="#" class="toggle">Toggle</a>

<%--        --%>
        <button v-on:click.prevent="Post">发布任务</button>
    </form>
    <h3 id="ok" v-if="blog.submitted">任务发布成功！</h3>
<%--    展示端     --%>
    <div id="preview">
        <h3>任务总览</h3>
        <p>文章标题:{{blog.title}}</p>
        <p>写作指导:</p>
        <p>{{blog.guide}}</p>
        <p>关键字</p>
        <p>{{blog.keyword}}</p>
        <p>参与学生</p>
        <ul>
            <li v-for="writer in blog.writers">
                {{writer}}
            </li>
        </ul>
    </div>

</div>
<!-- partial -->
<%--list--%>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script  src="static/script/list-script.js"></script>
<%----%>
<script type="text/javascript">
    var vm = new Vue({
        el: ".app-post" ,
        data:{
            blog:{
                title:"hi-student",
                guide:"别水字数",
                keyword:"",
                categories:[],
                writers:[],
                submitted:false
            },
            search:"",
            students:[],
            keywords:["fluent","interesting","meaningful"]
        },
        methods:{
            Post:function(){
                this.$http.post("https://jsonplaceholder.typicode.com/posts/",{
                    title: this.blog.title,
                    guide:this.blog.guide,
                    keyword: this.blog.keyword,
                    writers: this.blog.writers
                }).then(function(data){
                    console.log(data);
                    this.blog.submitted=true;
                })
            },
        },
        created(){
            this.$http.get('https://jsonplaceholder.typicode.com/posts/')
                .then(function (data) {
                    this.students = data.body;
                })
        },
        computed:{
            filterStudents:function () {
                return this.students.filter((student)=>{
                    return student.title.match(this.search)
                })
            }
        }

    })
</script>

<%--样式布局--%>
<style>
    #add-blog *{
        box-sizing: border-box;
    }
    #add-blog{
        margin:20px auto;
        max-width:400px;
        padding:20px;

    }
    label{
        display: block;
        color: #ecf0f1;
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
        color: white;
    }
    h2{
        color: white;
    }
    p{
        color: #ecf0f1;
    }
    li{
        color:#ecf0f1;
    }

</style>
</body>
</html>
