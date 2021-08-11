<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/8/6
  Time: 10:50 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, inital-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>小组管理</title>
    <%--    基础地址--%>
    <base href="../../">
    <%--    vue包导入--%>
    <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <!--    vue-resource 包导入-->
    <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
    <%-- bootstrap导入   --%>
    <link rel="stylesheet" href="static/css/bootstrap.css">
</head>
<body>
<%--引入导航栏--%>
<%@include file="headleader.jsp"%>
<%--从session中获得user    --%>
<div class="app">
    <div id="GroupManager">
        <ul class="list-group" v-for="group in groups" :key="group.id">
            <li class="list-group-item" v-for="student in group" :key="student.id">

                <span class="badge">小组号：{{student.groupId}}</span>
                学号：{{ student.id }}
                 用户名：{{ student.username }}
            </li>
            <br/>
        </ul>

        <div>
            <div class="form-group">
                <label>学号：</label>
                <input type="text" class="form-control" v-model="student.id">
            </div>
            <div class="form-group">
                <label>学生用户名：</label>
                <textarea class="form-control" v-model="student.username"></textarea>
            </div>
            <div class="form-group">
                <label>小组号：</label>
                <select class="form-control" v-model="student.groupId">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
            </div>
            <div class="form-group">
                <input type="button" value="确定" class="btn btn-primary" @click="PostStudent">
            </div>
        </div>
    </div>
</div>
<%
    User loginUser=(User)request.getSession().getAttribute("User");
%>
<script type="text/javascript">
    var vm = new Vue({
        el: ".app" ,
        data:{

            students:[],
            groups:[
                [
                {studentId:"2019212001",studentName:"张四",group:1},
                // {studentId:"2019212002",studentName:"张二",group:1},
                // {studentId:"2019212003",studentName:"张三",group:1}
            ],
                [
                {studentId:"2019212004",studentName:"李一",group:2},
                {studentId:"2019212005",studentName:"李二",group:2},
                {studentId:"2019212006",studentName:"李三",group:2}
            ],
                [
                {studentId:"2019212007",studentName:"王一",group:3},
                {studentId:"2019212008",studentName:"王二",group:3},
                // {studentId:"2019212009",studentName:"王三",group:3}
            ]],
            teacherUsername:"",
            student:{
                username:"",
                id: Number(),
                groupId: Number()
            }
        },
        methods: {
            //学生注册
            PostStudent(){
                if (this.student.groupId !=''&&this.student.username!=''&&this.studentId!=''){
                    var student = {
                        id: Number(this.student.id),
                        username: this.student.username,
                        groupId: Number(this.student.groupId),
                        teacherUsername: '<%=loginUser.getUsername()%>',
                        speeches: Number(0)
                    }
                    this.$http.post("addstudenttogroupservlet",JSON.stringify(student)).then(function (data) {
                        console.log(student)
                    })

                }
            },
            //学生加载
            LoadStudents(){
                this.$http.get("showgroupsservlet").then(function(data){
                    this.groups=data.body;
                    console.log(this.groups);
                })
            }
            // //评论发布
            // postComments() {
            //     if (this.user != '' && this.content != '') {
            //         var comment = {
            //             id: Date.now(),
            //             user: this.user,
            //             content: this.content,
            //             title: this.title,
            //             context: this.context
            //         }
            //         this.$http.post('addcommentsevlet', JSON.stringify(comment)).then(function (data) {
            //             console.log(data);
            //             console.log(comment)
            //         })
            //         //
            //         // var list = JSON.parse(localStorage.getItem('cmts') || '[]')
            //         // list.unshift(comment)
            //         // localStorage.setItem('cmts', JSON.stringify(list))
            //         // this.user = this.content = ''
            //         // this.$emit('func')
            //         this.list=list
            //     }
            // },
            // loadComments(){
            //     //var list = JSON.parse(localStorage.getItem('cmts') || '[]')
            //     //this.list = list
            //     this.$http.get("showcommentservlet")
            //         .then(function (data) {
            //             this.groups = data.body;
            //             console.log(this.groups);
            //         })
            // }
        },
        created(){
            this.LoadStudents();
        }

    })
</script>
</body>
</html>
