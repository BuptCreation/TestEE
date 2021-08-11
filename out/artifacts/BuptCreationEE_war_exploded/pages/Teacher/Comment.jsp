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

<div id="tmpl">
    <div id="blog">
        <h1>{{title}}</h1>
        <h4>{{context}}</h4>
        <h4>关键词:编使劲编</h4>
        <h2 style="float: right">作者:营销号</h2>
    </div>
    <div id="comment">
        <ul class="list-group">
            <li class="list-group-item" v-for="item in list" :key="item.id">
                <span class="badge">评论人：{{ item.user }}</span>
                {{ item.content }}
            </li>
        </ul>
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
</div>
<script type="text/javascript">
    var vm = new Vue({
        el: "#tmpl" ,
        data:{
            title:'',
            context:'',
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
            //评论发布
            postComments() {
                if (this.user!=''&&this.content!='') {
                    var comment = {id: Date.now(), user: this.user, content: this.content,title:this.title,context:this.context}
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
            var thisblog={title:this.title,context:this.context};
            this.$http.post("showcommentservlet",JSON.stringify(thisblog));
            this.loadComments();
        }

    })
</script>
<style>
    #comment{
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

