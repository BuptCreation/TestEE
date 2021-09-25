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
    <title>卿欲使我评点一二乎？</title>
    <%--    基础地址--%>
    <base href="../../">
<%--  评分样式导入  --%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="static/css/grade-style.css" rel="stylesheet"/>
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
            <h1>{{title}}</h1>
            {{context}}
        </div>

        <div class="container-card">
            <p>赵，钱，孙，李</p>
        </div>
    </div>
<%--评论展示区    --%>
    <div id="comment">
<%--        <ul class="list-group">--%>
<%--            <li class="list-group-item" v-for="item in list" :key="item.id">--%>
<%--                <span class="badge">评论人：{{ item.user }}</span>--%>
<%--                {{ item.content }}--%>
<%--            </li>--%>

<%--        </ul>--%>
    <div class="box">
        <ul id="first-list">
            <li  v-for="item in list" :key="item.id">
                <span></span>
                <div class="title">《评论》</div>
                <div class="info"> {{ item.content }}</div>
                <div class="name">{{ item.user }}</div>
                <div class="time">
                    <span>JUN, 17<sup>th</sup></span>
                    <span>12:00 AM</span>
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
            <div class="rating">
                <!--标题展示        -->
                <h2 class="text">词汇使用{{vocabulary}}</h2>
<%--                <label>评分：</label>--%>
                <!-- 选择表情       -->
                <input type="radio" name="star1" id="star1" value="7" v-model="vocabulary">
                <label for="star1">
                    <img src="static/img/非常出色.png" alt="">
                    <h4>非常出色</h4>
                </label>
                <input type="radio" name="star1" id="star2" value="6" v-model="vocabulary">
                <label for="star2">
                    <img src="static/img/优秀.png" alt="">
                    <h4>优秀</h4>
                </label>
                <input type="radio" name="star1" id="star3"  value="5" v-model="vocabulary">
                <label for="star3">
                    <img src="static/img/良好.png" alt="">
                    <h4>良好</h4>
                </label>
                <!-- 默认选择的表情       -->
                <input type="radio" name="star1" id="star4"  value="4" v-model="vocabulary" checked="checked">
                <label for="star4">
                    <img src="static/img/尚可.png" alt="">
                    <h4>尚可</h4>
                </label>
                <input type="radio" name="star1" id="star5"  value="3" v-model="vocabulary">
                <label for="star5">
                    <img src="static/img/略差.png" alt="">
                    <h4>略差</h4>
                </label>
                <input type="radio" name="star1" id="star6"  value="2" v-model="vocabulary">
                <label for="star6">
                    <img src="static/img/较差.png" alt="">
                    <h4>较差</h4>
                </label>
                <input type="radio" name="star1" id="star7"  value="1" v-model="vocabulary">
                <label for="star7">
                    <img src="static/img/特别差.png" alt="">
                    <h4>特别差</h4>
                </label>
            </div>
        </div>
        <div class="form-group">
            <div class="rating">
                <!--标题展示        -->
                <h2 class="text">连贯与衔接{{fluent}}</h2>
                <%--                <label>评分：</label>--%>
                <!-- 选择表情       -->
                <input type="radio" name="star2" id="star21" value="7" v-model="fluent">
                <label for="star21">
                    <img src="static/img/非常出色.png" alt="">
                    <h4>非常出色</h4>
                </label>
                <input type="radio" name="star2" id="star22" value="6" v-model="fluent">
                <label for="star22">
                    <img src="static/img/优秀.png" alt="">
                    <h4>优秀</h4>
                </label>
                <input type="radio" name="star2" id="star23"  value="5" v-model="fluent">
                <label for="star23">
                    <img src="static/img/良好.png" alt="">
                    <h4>良好</h4>
                </label>
                <!-- 默认选择的表情       -->
                <input type="radio" name="star2" id="star24"  value="4" v-model="fluent" checked="checked">
                <label for="star24">
                    <img src="static/img/尚可.png" alt="">
                    <h4>尚可</h4>
                </label>
                <input type="radio" name="star2" id="star25"  value="3" v-model="fluent">
                <label for="star25">
                    <img src="static/img/略差.png" alt="">
                    <h4>略差</h4>
                </label>
                <input type="radio" name="star2" id="star26"  value="2" v-model="fluent">
                <label for="star26">
                    <img src="static/img/较差.png" alt="">
                    <h4>较差</h4>
                </label>
                <input type="radio" name="star2" id="star27"  value="1" v-model="fluent">
                <label for="star27">
                    <img src="static/img/特别差.png" alt="">
                    <h4>特别差</h4>
                </label>
            </div>
        </div>
        <div class="form-group">
            <div class="rating">
                <!--标题展示        -->
                <h2 class="text">语法多样性{{variety}}</h2>
                <%--                <label>评分：</label>--%>
                <!-- 选择表情       -->
                <input type="radio" name="star3" id="star31" value="7" v-model="variety">
                <label for="star31">
                    <img src="static/img/非常出色.png" alt="">
                    <h4>非常出色</h4>
                </label>
                <input type="radio" name="star3" id="star32" value="6" v-model="variety">
                <label for="star32">
                    <img src="static/img/优秀.png" alt="">
                    <h4>优秀</h4>
                </label>
                <input type="radio" name="star3" id="star33"  value="5" v-model="variety">
                <label for="star33">
                    <img src="static/img/良好.png" alt="">
                    <h4>良好</h4>
                </label>
                <!-- 默认选择的表情       -->
                <input type="radio" name="star3" id="star34"  value="4" v-model="variety" checked="checked">
                <label for="star34">
                    <img src="static/img/尚可.png" alt="">
                    <h4>尚可</h4>
                </label>
                <input type="radio" name="star3" id="star35"  value="3" v-model="variety">
                <label for="star35">
                    <img src="static/img/略差.png" alt="">
                    <h4>略差</h4>
                </label>
                <input type="radio" name="star3" id="star36"  value="2" v-model="variety">
                <label for="star36">
                    <img src="static/img/较差.png" alt="">
                    <h4>较差</h4>
                </label>
                <input type="radio" name="star3" id="star37"  value="1" v-model="variety">
                <label for="star37">
                    <img src="static/img/特别差.png" alt="">
                    <h4>特别差</h4>
                </label>
            </div>
        </div>
        <div class="form-group">
            <div class="rating">
                <!--标题展示        -->
                <h2 class="text">任务完成度{{complete}}</h2>
                <%--                <label>评分：</label>--%>
                <!-- 选择表情       -->
                <input type="radio" name="star4" id="star41" value="7" v-model="complete">
                <label for="star41">
                    <img src="static/img/非常出色.png" alt="">
                    <h4>非常出色</h4>
                </label>
                <input type="radio" name="star4" id="star42" value="6" v-model="complete">
                <label for="star42">
                    <img src="static/img/优秀.png" alt="">
                    <h4>优秀</h4>
                </label>
                <input type="radio" name="star4" id="star43"  value="5" v-model="complete">
                <label for="star43">
                    <img src="static/img/良好.png" alt="">
                    <h4>良好</h4>
                </label>
                <!-- 默认选择的表情       -->
                <input type="radio" name="star4" id="star44"  value="4" v-model="complete" checked="checked">
                <label for="star44">
                    <img src="static/img/尚可.png" alt="">
                    <h4>尚可</h4>
                </label>
                <input type="radio" name="star4" id="star45"  value="3" v-model="complete">
                <label for="star45">
                    <img src="static/img/略差.png" alt="">
                    <h4>略差</h4>
                </label>
                <input type="radio" name="star4" id="star46"  value="2" v-model="complete">
                <label for="star46">
                    <img src="static/img/较差.png" alt="">
                    <h4>较差</h4>
                </label>
                <input type="radio" name="star4" id="star47"  value="1" v-model="complete">
                <label for="star47">
                    <img src="static/img/特别差.png" alt="">
                    <h4>特别差</h4>
                </label>
            </div>
        </div>
        <div class="form-group">
            <input type="button" value="发表评论" class="butt" @click="postComments">
        </div>
    </div>
    </div>
</div>
<script type="text/javascript">
    var vm = new Vue({
        el: "#tmpl" ,
        data:{
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
                if (this.user!=''&&this.content!='') {
                    var comment = {id: Date.now(), user: this.user, content: this.content,title:this.title,textno:this.textno,context:this.context,
                        vocabulary:Number(this.vocabulary),fluent: Number(this.fluent),variety: Number(this.variety),complete: Number(this.complete)}
                    this.$http.post('addcommentsevlet',JSON.stringify(comment)).then(function(data){
                        console.log(data);
                        this.loadComments();
                    })
                    //
                    // var list = JSON.parse(localStorage.getItem('cmts') || '[]')
                    // list.unshift(comment)
                    // localStorage.setItem('cmts', JSON.stringify(list))
                    // this.user = this.content = ''
                    // this.$emit('func')
                    // this.list=list
                }
            },
            loadComments(){
                //var list = JSON.parse(localStorage.getItem('cmts') || '[]')
                //this.list = list
                //loadcomment 要做判断 数据库中评论的title 要等于 这个title
                this.$http.get("showcommentservlet")
                    .then(function (data) {
                        this.list = data.body.slice(0,10);
                        console.log(this.blogs);
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
            this.$http.post("showcommentservlet",JSON.stringify(thisblog));
            this.loadComments();
        }

    })
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
        color: white;
        padding: 10px;
        font-size: 20px;
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


