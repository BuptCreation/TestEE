<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/7/29
  Time: 6:47 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, inital-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>评论区</title>
    <%--    基础地址--%>
    <base href="../../">
<%--    vue包导入--%>
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
<%-- bootstrap导入   --%>
    <link rel="stylesheet" href="static/css/bootstrap.css">
<%--    温馨提示--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="static/css/roll-style-teacher.css">
<%--    背景--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel="stylesheet" href="static/css/teacher-background-style.css">
<%--打分部分样式--%>
    <link type="text/css" href="static/css/score-style.css" rel="stylesheet" />
</head>
<%--从session中获得user    把名字填入评论人--%>
<%
    User loginUser=(User)request.getSession().getAttribute("User");
%>
    <%@include file="headleader.jsp"%>
<%--背景--%>
<%--<div id="top-image"></div>--%>
<%--  温馨提示--%>
    <div class="reminder">
        <div class="text">
            <p>Please be&nbsp
                <span class="word wisteria">polite.</span>
                <span class="word belize">patient.</span>
                <span class="word pomegranate">fancy.</span>
                <span class="word green">friendly.</span>
                <span class="word midnight">kind.</span>
            </p>
        </div>
    </div>
    <br/><br/><br/><br/><br/><br/>
<%--    --%>
<%--评论展示区--%>
<div id="tmpl">
    <div class="card">
        <div class="header" style="white-space: pre-wrap">
            <h1 style="text-align: center">{{title}}</h1>
            <div class="content">{{context}} </div>
        </div>

        <div class="container-card">
            <p>{{date}}</p>
        </div>
    </div>

<%--评论展示区    --%>
    <div id="comment">
    <div class="box">
        <ul id="first-list">
            <li  v-for="item in list" :key="item.id">
                <span></span>
                <div class="title">写作内容:{{item.complete}}分</div>
                <div class="title">结构与衔接:{{item.fluent}}分</div>
                <div class="title">语法使用:{{item.variety}}分</div>
                <div class="title">词汇运用:{{item.vocabulary}}分</div>
                <div class="title">写作规范:{{item.specification}}分</div>
                <div class="info"> {{ item.content }}</div>
                <div class="name">{{ item.user }}</div>
                <div class="time">
                    <span>{{item.date.slice(0,10)}}</span>
                    <span>{{item.date.slice(11,19)}}</span>
                </div>
            </li>
        </ul>
    </div>
<%--作品评论区--%>
    <div class="container-comment" v-show="permission === 'true'">
        <div class="form-group">
            <label>评论人：</label>
            <input type="text" class="form-control" v-model="user">
        </div>
        <div class="form-group">
            <label>评论内容：</label>
            <textarea class="form-control" v-model="content"></textarea>
        </div>
        <div class="form-group">
            <input type="button" value="发表评论" class="butt" @click="postComments">
        </div>
    </div>
    </div>
</div>
<%--   打分区     --%>
<div class="container-comment">
<div class="grade_warp">

    <div class="User_ratings User_grade" id="div_fraction0">
        <div class="ratings_title01"><p><span>写作内容</span>-你觉得这篇文章的内容出色吗？<i>分数越高表示越优秀。</i></p></div>
        <div class="ratings_bars">
            <span id="title0">0</span>
            <span class="bars_10">0</span>
            <div class="scale" id="bar0">
                <div></div>
                <span id="btn0"></span>
            </div>
            <span class="bars_10">5</span>
        </div>
    </div>

    <div class="User_ratings User_grade" id="div_fraction1">
        <div class="ratings_title01"><p><span>结构与衔接</span>-你觉得这篇文章在结构与衔接上优秀吗？<i>分数越高表示越优秀。</i></p></div>
        <div class="ratings_bars">
            <span id="title1">0</span>
            <span class="bars_10">0</span>
            <div class="scale" id="bar1">
                <div></div>
                <span id="btn1"></span>
            </div>
            <span class="bars_10">5</span>
        </div>
    </div>

    <div class="User_ratings User_grade" id="div_fraction2">
        <div class="ratings_title01"><p><span>词汇运用</span>-你觉得这篇文章在词汇运用上优秀吗？<i>分数越高表示越优秀。</i></p></div>
        <div class="ratings_bars">
            <span id="title2">0</span>
            <span class="bars_10">0</span>
            <div class="scale" id="bar2">
                <div></div>
                <span id="btn2"></span>
            </div>
            <span class="bars_10">5</span>
        </div>
    </div>

    <div class="User_ratings User_grade" id="div_fraction3">
        <div class="ratings_title01"><p><span>语法使用</span>-你觉得这篇文章在语法使用上可行吗？<i>分数越高表示越可行。</i></p></div>
        <div class="ratings_bars">
            <span id="title3">0</span>
            <span class="bars_10">0</span>
            <div class="scale" id="bar3">
                <div></div>
                <span id="btn3"></span>
            </div>
            <span class="bars_10">5</span>
        </div>
    </div>

    <div class="User_ratings User_grade" id="div_fraction4">
        <div class="ratings_title01"><p><span>写作规范</span>-你觉得这篇文章写作规范吗？<i>分数越高表示越优秀。</i></p></div>
        <div class="ratings_bars">
            <span id="title4">0</span>
            <span class="bars_10">0</span>
            <div class="scale" id="bar4">
                <div></div>
                <span id="btn4"></span>
            </div>
            <span class="bars_10">5</span>
        </div>
    </div>
</div>
</div>
<p style="clear:both"></p>
<script type="text/javascript">
    var vm = new Vue({
        el: "#tmpl" ,
        data:{
            date:"",
            textno:"",
            permission:"false",
            title:'',
            context:'',
            user:'<%=loginUser.getUsername()%>',
            content: '',
            vocabulary:4,
            fluent:4,
            variety:4,
            complete:4,
            list:[
                { time: Date.now(), user: '路人甲', content: '武汉加油' },
                { time: Date.now(), user: '炮灰乙', content: '中国加油' },
                { time: Date.now(), user: '小兵丙', content: '广东加油' },
                { time: Date.now(), user: '土匪丁', content: '全球加油' }
            ]
        },
        methods:{
            //评论发布
            postComments() {
                var vocabulary = document.getElementById("title2").innerText;
                var fluent = document.getElementById("title1").innerText;
                var variety = document.getElementById("title3").innerText;
                var complete = document.getElementById("title0").innerText;
                var specification = document.getElementById("title4").innerText;
                if (this.user==''||this.content=='') {
                    alert("请先填写评论内容再提交");
                }else if(vocabulary==0||fluent==0||variety==0||complete==0||specification==0){
                    alert("请先打分再提交");
                }else{
                    var comment = {id: <%=loginUser.getId()%>, user: this.user, content: this.content,title:this.title,textno:this.textno,context:this.context,
                        vocabulary:parseFloat(vocabulary),fluent: parseFloat(fluent),variety:parseFloat(variety),complete:parseFloat(complete),specification:parseFloat(specification)}
                        this.$http.post('addcommentsevlet',JSON.stringify(comment)).then(function(data){
                        console.log(data);
                        this.loadComments();
                    })
                    this.content="";
                }
            },
            loadComments(){
                //var list = JSON.parse(localStorage.getItem('cmts') || '[]')
                //this.list = list
                //loadcomment 要做判断 数据库中评论的title 要等于 这个title
                this.$http.get("showcommentservlet")
                    .then(function (data) {
                        this.list = data.body.reverse();
                        console.log(this.list);
                    })
            }
        },
        created(){
            var blog=JSON.parse(localStorage.getItem('blog')||'[]')
            this.title=blog.title

            this.context=blog.content
            this.permission=blog.permission
            this.textno=blog.textno
            console.log(this.permission)
            var thisblog={title:this.title,context:this.context,textno:this.textno};
            //加载整篇文章
            this.$http.post("showcontentbytextnoservlet",JSON.stringify(thisblog)).then(function () {
                this.$http.get("showcontentbytextnoservlet").then(function(data){
                    this.date=data.data.date;
                    this.context=data.data.content;
                });
            })
            this.$http.post("showcommentservlet",JSON.stringify(thisblog));
            this.loadComments();
        }
    })
</script>
<script>
    //尝试初始化打分功能
    scale = function (btn, bar, title) {
        this.btn = document.getElementById(btn);
        this.bar = document.getElementById(bar);
        this.title = document.getElementById(title);
        this.step = this.bar.getElementsByTagName("DIV")[0];

        this.init();
    };
    scale.prototype = {
        init: function () {
            var f = this, g = document, b = window, m = Math;
            f.btn.onmousedown = function (e) {
                var x = (e || b.event).clientX;
                var l = this.offsetLeft;
                var max = f.bar.offsetWidth - this.offsetWidth;
                g.onmousemove = function (e) {
                    var thisX = (e || b.event).clientX;
                    var to = m.min(max, m.max(-2, l + (thisX - x)));
                    f.btn.style.left = to + 'px';
                    f.ondrag(m.round(m.max(0, to / max) * 100), to);
                    b.getSelection ? b.getSelection().removeAllRanges() : g.selection.empty();
                };
                g.onmouseup = new Function('this.onmousemove=null');
            };
        },
        ondrag: function (pos, x) {
            console.log("pos"+pos+","+"x"+x);
            this.step.style.width = Math.max(0, x) + 'px';
            this.title.innerHTML = Math.floor(pos /10)*0.5 + '';
        }
    }
    new scale('btn0', 'bar0', 'title0');
    new scale('btn1', 'bar1', 'title1');
    new scale('btn2', 'bar2', 'title2');
    new scale('btn3', 'bar3', 'title3');
    new scale('btn4', 'bar4', 'title4');
</script>
<style>
    body{
        margin: 0;
        padding: 0;
        background-image: url(static/img/commentback.JPG);
        background-repeat: no-repeat;
        background-size:cover;  /* 让背景图基于容器大小伸缩 */
        background-attachment:fixed;
        font-family: arial
    }
    .list-group{
        width: 40%;
        float: right;
        margin: 10px;
    }
    .container-comment{
        margin: 20px;
        width: 55%;
        float: left;
        box-shadow: 10px 10px 5px #888888;
        /*background: white;*/
    }
    #blog{
        margin: 20px;
        width: 55%;
        float: left;
        box-shadow: 10px 10px 5px #888888;
        background: white;
    }
    .box{
        float: right;
        /*margin:0 10%;*/
        width: 40%;
        height: 100%;
        max-height: 800px;
        overflow-y:scroll;
        padding: 10px 0 40px 60px

    }

    .box ul{
        list-style-type: none;
        margin: 0;
        padding: 0;
        position: relative;
        transition: all 0.5s linear;
        top:0
    }

    .box ul:last-of-type{top:80px}

    .box ul:before{
        content: "";
        display: block;
        width: 0;
        height: 100%;
        border:1px dashed #fff;
        position: absolute;
        top:0;
        left:30px
    }

    .box ul li{
        margin: 20px 60px 60px;
        position: relative;
        padding: 10px 20px;
        background:rgba(255, 255, 255, 0.3);
        color:#333333;
        border-radius: 10px;
        line-height: 20px;
    }


    .box ul li > span{
        content: "";
        display: block;
        width: 0;
        height: 100%;
        border:1px solid #fff;
        position: absolute;
        top:0;
        left:-30px
    }

    .box ul li > span:before,.box ul li > span:after{
        content: "";
        display: block;
        width: 10px;
        height: 10px;
        border-radius: 50%;
        background:#91b7de;
        border:2px solid #fff;
        position: absolute;
        left:-5px
    }

    .box ul li > span:before{top:-10px}
    .box ul li > span:after{top:95%}

    .box .title{
        text-transform: uppercase;
        font-weight: 700;
        margin-bottom: 5px
    }
    .box .info:first-letter{text-transform: capitalize;line-height: 1.7}

    .box .name{
        margin-top: 10px;
        text-transform: capitalize;
        font-style: italic;
        text-align: right;
        margin-right: 20px
    }


    .box .time span{
        position: absolute;
        left: -100px;
        color:#333333;
        font-size:80%;
        font-weight: bold;
    }
    .box .time span:first-child{top:-16px}
    .box .time span:last-child{top:94%}
    div.card {
        margin: 20px;
        width: 55%;
        /*height: 700px;*/
        max-height: 800px;
        overflow-x: hidden;
        /*overflow-y: scroll;*/
        float: left;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        /*text-align: center;*/
    }

    div.header {
        /*overflow-y: scroll;*/
        opacity: 0.5;
        background:#91b7de;
        color: black;
        padding: 10px;
        font-size: 20px;
    }
    div.content{
        padding:10px;
    }
    div.container-card {
        font-style: italic;
        padding: 10px;
        font-size: 15px;
        text-align: center;
    }

    .butt {
        font-size: 15px;
        width: 100%;
        height: 50px;
        background-color: white;
        color: black;
        border: 2px solid #008CBA;
    }

    .butt:hover {
        font-size: 30px;
        background-color: #008CBA;
        color: white;
    }

</style>
<%--    温馨提示--%>
    <script  src="static/script/roll-script-teacher.js"></script>
<%--背景--%>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script  src="static/script/teacher-background-script.js"></script>

</body>
</html>


