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
    <style>
        /*按钮美化*/
        .butt {
            margin: 10px;
            float: right;
            width: 100px;
            height: 30px;
            background-color: white;
            color: black;
            align-self: center;
            border: 2px solid #555555;
        }
        .butt:hover {
            background-color: #555555;
            color: white;
        }
        /*弹窗*/
        .mask{
            z-index: 999;
            width: 100%;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background: rgba(0,0,0,0.6);
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .box{
            background: #fff;
            padding: 40px;
            border-radius: 8px;
            width: 30%;
        }
    </style>
</head>
<body>
<%-- 修改昵称   --%>

    <%@include file="headleader.jsp"%>
    <%--从session中获得user    --%>

    <%
        User loginUser=(User)request.getSession().getAttribute("User");
        String UserNickname = loginUser.getNickname();
        if (UserNickname==null){
            UserNickname="未命名";
        }
    %>
    <!--  -->
    <section class="intro">
        <div class="container">
            <h1><!--  -->
                <div id="app">
                    <!--    {{mask}}-->
                    <!--    <br/>-->
                    <!--    {{textno}}-->
                    <button class="butt" @click="show()" style="font-size: medium">修改信息</button>
                    <div class="mask" v-if="mask" @click="close()">
                        <div class="box" @click.stop="">
                            <div class="input-group" style="padding:5px">
                                <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                                <input type="text" class="form-control" placeholder="昵称" id="usr" name="username" v-model="nickname">
                            </div>
                            <div class="input-group" style="padding:5px">
                                <div class="input-group-addon">我的教师</div>
                                <select class="form-control" v-model="teacher">
                                    <option v-for="allteacher in teachers">{{allteacher.teacherNickname}}</option>
                                </select>
                            </div>

                            <div class="input-group" style="padding:5px" v-show="teacher != ''">
                                <div class="input-group-addon">我的小组</div>
                                <select class="form-control" v-model="groupid">
                                    <option v-for="groupid in  groupfilter">{{groupid}}</option>
                                </select>
                            </div>
                            <button class="butt" style="font-size: medium" @click="Active()">确认更改</button>
                        </div>

                    </div>
                </div>
                <section class="intro">
                    <div class="container">
                        <h1 align="center">欢迎你登陆！<%=loginUser.getUsername()%> 查看你的最新消息吧</h1>
                        <h1> 现在你在第<%=request.getSession().getAttribute("Groupid")%>组</h1>
                        <h1> 你的组员有<%=request.getSession().getAttribute("Groupmembers")%></h1>
                    </div>
                </section>

                <section class="timeline">
                    <ul class="messages" style="min-height:50%">
                    </ul>
                </section>
                </h1>
        </div>
    </section>

<script>
    var messages;
    function goComment(title,body,permission,textno){
        console.log("点击事件触发")
        commentblog={title:title,content:body,permission:permission,textno:textno}
        localStorage.setItem('blog',JSON.stringify(commentblog))
        window.location.href="pages/Student/Comment.jsp"
    }
    $(function(){
        $.getJSON("shownewsservlet",function (data) {
            //0.有关注册方面的消息，给予用户
            //如果用户没有昵称，提示用户改名
            if ("<%=UserNickname%>"=="未命名"){
                var str = " <li>\n" +
                    "                            <div style='font-size:large'>\n" +
                    "                               "+"<br/><br/><time><span  class=\"label label-info\">信息提示</span></time>"+"您还没有昵称，点击右上角修改信息，起个名字吧(由于时间原因程序员小哥还未实现该功能)"+"<br/>"+
                    "                            </div>\n" +
                    "       </li>";
                $(".messages").prepend(str);
            }


            //1.给用户引导；固定 2。给用户提示信息
            $.each(data,function (i,message) {
                console.log(message)
                if (message.type=="invite") {
                    //用户的message（type:信息类型）
                    //个人主页，收到提示  提示他去评论对应作品
                    var str = " <li>\n" +
                        "                            <div style='font-size:large'>\n" +
                        "                               "+message.date+"<br/><br/><time><span  class=\"label label-info\">作品互评</span></time>"+"老师邀请您评论小组"+message.groupid+"的文章《"+message.title + "》点击按钮进行评论 \n"+"<br/>"+
                        "<button class=\"btn btn-info btn-lg\" onclick='goComment(\""+message.title+"\",\""+message.content+"\",\""+"true"+"\",\""+message.textno+"\")'><span class=\"glyphicon glyphicon-pencil\"></span>评论</button>"+
                        "                            </div>\n" +
                        "       </li>";
                    $(".messages").prepend(str);
                }else if (message.type=="suggest"){
                    //个人主页，收到提示 我的作品已经被人评论完了
                    var str = " <li>\n" +
                        "                            <div style='font-size:large'>\n" +
                        "                               "+message.date+"<br/><br/><time><span  class=\"label label-success\">作品互评</span></time>"+"您的文章《"+message.title + "》有新的评论了，点击查看结果 \n"+"<br/>"+
                        "<button class=\"btn btn-success btn-lg\" onclick='goComment(\""+message.title+"\",\""+message.content+"\",\""+"false"+"\",\""+message.textno+"\")'><span class=\"glyphicon glyphicon-search\"></span>查看</button>"+
                        "                            </div>\n" +
                        "       </li>";
                    $(".messages").prepend(str);
                }else if (message.type=="group"){
                    //个人主页，收到提示 小组消息 上面那种组合方式真的垃圾下面换种好康的
                    var strVar="";
                    strVar += "<li>";
                    strVar += "      <div>";
                    strVar += "          <time><span  class=\"label label-default\">小组消息<\/span><\/time> ";
                    strVar += "<span class=\"glyphicon glyphicon-user\">"+message.content;
                    strVar += "<time><span class=\"glyphicon glyphicon-plus\">附加消息:"+message.extraInfo;
                    strVar += "      <\/div>";
                    strVar += "<\/li>";
                    $(".messages").prepend(strVar);
                }else if (message.type=="chatroom") {
                    //个人主页，收到提示 小组消息 上面那种组合方式真的垃圾下面换种好康的
                    var strVar = "";
                    strVar += "<li>";
                    strVar += "      <div>";
                    strVar += "          <time><span  class=\"label label-primary\">聊天提醒<\/span><\/time> ";
                    strVar += "<span class=\"glyphicon glyphicon-comment\">" + message.content;
                    strVar += "<time><span class=\"glyphicon glyphicon-plus\">附加消息:" + message.extraInfo;
                    strVar += "      <\/div>";
                    strVar += "<\/li>";
                    $(".messages").prepend(strVar);
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
<script>
    var vm = new Vue({
        el:'#app',
        data:{
            teachers:[ { teacherNickname:"张老师",groups:[1,2]},
                { teacherNickname:"胡老师",groups:[1,2,3]},
                { teacherNickname:"苏老师",groups:[1,2,4]}
            ],
            groupid:NaN,
            teacher:"",
            nickname:"",
            mask:false
        },
        methods:{
            show(){
                this.mask=!this.mask;
            },
            close(){
                this.mask=!this.mask;
            },
            Active(){
                console.log(this.nickname,this.teacher);
            }
        },
        computed:{
            groupfilter:function(){
                for (var i=0;i<this.teachers.length;i++){
                    if (this.teachers[i].teacherNickname==this.teacher) {
                        return this.teachers[i].groups;
                    }
                }
            }
        }
    })
</script>
    <!-- 提示表单样式js-->
<%--手动美化包 --%>
</body>

</html>
