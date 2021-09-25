<%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/9/22
  Time: 8:36 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>查看文章</title>
    <!--    基础路径-->
    <base href="../../">
    <!--    vue-基础包导入-->
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
    <%--bootstrap导入    --%>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <%--复选框美化    --%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="static/css/style-checkbox.css">
    <style>
        <%--按钮美化--%>
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
        /*文章搜索美化*/
        form {
            position: relative;
            width: 300px;
            margin: 0 auto;
        }

        input, button {
            border: none;
            outline: none;
        }

        input {
            width: 100%;
            height: 42px;
            padding-left: 13px;
        }
        .button {
            height: 42px;
            width: 42px;
            cursor: pointer;
            position: absolute;
        }

        /*搜索框1*/
        .bar1 input {
            border: 2px solid #8c8c8c;
            border-radius: 5px;
            /*background: #F9F0DA;*/
            color: #9E9C9C;
        }
        .bar1 button {
            top: 0;
            right: 0;
            background: #8c8c8c;
            border-radius: 0 5px 5px 0;
        }
        .bar1 button:before {
            content: "🔍";
            font-family: FontAwesome;
            font-size: 16px;
            color: #F9F0DA;
        }

        /*高亮关键字*/
        .highlight {
            color: #91b7de;
            font-family:STFangsong;
            font-size: 30px;
        }

        /*个人文章美化*/
        h2{
            font-size: larger;
        }
        #show_blogs{
            margin: 0 auto;
        }
        .blog{
            /*经测试 该颜色会和背景颜色叠加导致较差的效果*/
            /*background: #8c8c8c;*/
            width: 98%;
            padding: 20px;
            margin: 20px 0;
            border: 3px solid #ddd;
            border-radius: 4px;
            box-shadow: 5px 5px 5px #333333;
        }
        .detail{
            float: left;
            padding: 10px;
        }
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

<div id="show_blogs" style="overflow-y: scroll">
<%--    inviteGroup={{inviteGroup}}--%>
<%--    textno={{textno}}--%>
<%--    mask={{mask}}--%>
    <%--邀请弹窗    --%>
    <transition>
    <div class="mask" v-if="mask" @click="close()">
        <%--click.stop阻止冒泡        --%>
        <div class="box" @click.stop="">
            <div v-for="group in groups" >
                <input :id="group" :value="group" type="checkbox" value="group" v-model="inviteGroup"/>
                <label :for="group">小组{{group}}</label>
            </div>
            <button class="butt" @click="Sent()"></span>邀请</button>
        </div>

    </div>
    </transition>
    <%-- 搜索栏     --%>
    <div class="search bar1">
        <form>
            <input type="text" class="search" v-model="search" placeholder="搜索">
            <button disabled="disabled" class="button" type="submit"></button>
        </form>
    </div>

    <%-- 具体博客           --%>
    <blog class="single-blog" v-for="blog in filterblogs">
        <div class="blog">
            <h3 v-html="State(blog.has1writed,blog.has2writed,blog.has3writed)"></h3>
            <br/>
            <h2 v-html="highlight(blog.title)"></h2>
            <br/>
            <article>{{blog.content|snippet}}</article>
            <div class="detail"><span class="glyphicon glyphicon-star-empty"></span>&nbsp;{{blog.averagevocabularypoint}}</div>
            <div class="detail"><span class="glyphicon glyphicon-star-empty"></span>&nbsp;{{blog.averagefluentpoint}}</div>
            <div class="detail"><span class="glyphicon glyphicon-star-empty"></span>&nbsp;{{blog.averagevarietypoint}}</div>
            <div class="detail"><span class="glyphicon glyphicon-star-empty"></span>&nbsp;{{blog.averagecompletepoint}}</div>
            <div class="detail"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;{{blog.browsertimes}}</div>
            <div class="detail"><span class="glyphicon glyphicon-comment"></span>&nbsp;{{blog.commentCount}}</div>
            <br/>
            <br/>
            <div class="detail"><span class="glyphicon glyphicon-user"></span>{{blog.writer|cut}}</div>
            <button class="butt" @click="Invite(blog.textno)"><span class="glyphicon glyphicon-pencil"></span>邀请评论</button>
            <br/>
        </div>
    </blog>
</div>
<%--Vue查找模块--%>
<script>

    var vm = new Vue({
        el:'#show_blogs',
        data:{
            inviteGroup:[],
            blogs:[],
            search:"",
            test:"success",
            groups:[
                1,2,3,4
            ],
            textno:"",
            mask:false
        },
        created(){
            this.$http.get('showallblogsservlet').then(function(data){
                this.blogs = data.body;
                console.log(this.blogs);
            })
            this.$http.get('showgroupnoservlet').then(function(data){
                this.groups=data.body;
                console.log(data.body);
            })
        },
        methods: {
            highlight(value){
                val=value.replace(this.search,"<span class=highlight>"+this.search+"</span>")
                return val;
            }
            ,
            Invite(textno){
                this.textno=textno;
                this.mask=!this.mask;
            }
            ,
            close(){
                //归零
                this.mask=!this.mask;
                this.textno="";
                this.inviteGroup=[];
            },
            State(has1writed,has2writed,has3writed){
                if (has3writed==true){
                    return "<span style='color: greenyellow'>三稿已完成</span>"
                }else if (has2writed==true){
                    return "<span style='color: lightskyblue'>二稿已完成</span>"
                }else if (has1writed==true){
                    return "<span style='color: #64bdba'>一稿已完成</span>"
                }else{
                    return "<span style='color: gray'>未交稿</span>"
                }
            },
           Sent(){
               var invite = {textno:this.textno,inviteGroup:this.inviteGroup}
               this.$http.post('https://jsonplaceholder.typicode.com/posts/',JSON.stringify(invite)).then(function(data){
                   console.log(data);
               })
               alert("已发送");
           }
        },
        computed:{
            filterblogs:function(){
                return this.blogs.filter((blog)=>{
                    return blog.title.match(this.search);
                })
            }
        },
    })
    //省略过长的文本
    Vue.filter("snippet",function(value){
        if (value) {
            return value.slice(0, 100) + "..."
        }else {
            return value
        }
    })
    //省略
    Vue.filter("cut",function (value) {
        return value.slice(1,value.length-1);
    })
</script>
</body>
</html>
