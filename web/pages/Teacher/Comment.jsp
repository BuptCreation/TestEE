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
    <title>作品评论</title>
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
</head>
<%--从session中获得user    把名字填入评论人--%>
<%
    User loginUser=(User)request.getSession().getAttribute("User");
%>
    <%@include file="headleader.jsp"%>
<%--背景--%>
<div id="top-image"></div>
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
    <br/><br/><br/>
<%--    --%>
<div id="blog">
    <h1>协同写作</h1>
    <h4>协同写作平台协同写作是怎么回事呢？协同写作平台相信大家都很熟悉，但是协同写作平台协同写作是怎么回事呢，下面就让小编带大家一起了解吧。
        　　协同写作平台协同写作，其实就是多个人一起写作，大家可能会很惊讶协同写作平台怎么会协同写作呢？但事实就是这样，小编也感到非常惊讶。
        　　这就是关于协同写作平台协同写作的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！</h4>
    <h4>关键词:编使劲编</h4>
    <h2 style="float: right">作者:营销号</h2>
</div>
<div id="tmpl">
    <div >
        <ul class="list-group">
            <li class="list-group-item" v-for="item in list" :key="item.id">
                <span class="badge">评论人：{{ item.user }}</span>
                {{ item.content }}
            </li>
        </ul>
    </div>
    <div>
        <div class="form-group">
            <label>评论人：</label>
            <input type="text" class="form-control" v-model="user">
        </div>
        <div class="form-group">
            <label>评论内容：</label>
            <textarea class="form-control" v-model="content"></textarea>
        </div>
        <div class="form-group">
            <input type="button" value="发表评论" class="btn btn-primary" @click="postComments">
        </div>
    </div>
</div>
<script type="text/javascript">
    var vm = new Vue({
        el: "#tmpl" ,
        data:{
            user:'<%=loginUser.getUsername()%>',
            content: '',
            list:[
                { time: Date.now(), user: '路人甲', content: '武汉加油' },
                { time: Date.now(), user: '炮灰乙', content: '中国加油' },
                { time: Date.now(), user: '小兵丙', content: '广东加油' },
                { time: Date.now(), user: '土匪丁', content: '全球加油' }
            ]
        },
        methods:{
            postComments() {
                if (this.user!=''&&this.content!='') {
                    var comment = {id: Date.now(), user: this.user, content: this.content}
                    var list = JSON.parse(localStorage.getItem('cmts') || '[]')
                    list.unshift(comment)
                    localStorage.setItem('cmts', JSON.stringify(list))
                    this.user = this.content = ''
                    this.$emit('func')
                    this.list=list
                }
            },
            loadComments(){
                var list = JSON.parse(localStorage.getItem('cmts') || '[]')
                this.list = list
            }
        },
        created(){
            this.loadComments()
        }

    })
</script>
<style>
    #tmpl{
        width: 40%;
        float: right;
        padding: 10px;
    }
    #blog{
        width: 55%;
        float: left;
        box-shadow: 10px 10px 5px #888888;
        background: white;
    }
</style>
<%--    温馨提示--%>
    <script  src="static/script/roll-script-teacher.js"></script>
<%--背景--%>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script  src="static/script/teacher-background-script.js"></script>

</body>
</html>


