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
        <div style="overflow-y: scroll;max-height: 800px">
        <ul class="list-group">
            <li style="margin: 20px" class="list-group-item" v-for="student in groups" :key="student.id">

                <span class="badge">小组号：{{student.groupid}}</span>
                学号：{{ student.studentno }}
                 用户名：{{ student.studentname }}
            </li>
        </ul>
        </div>
        <div>
            <div class="form-group">
                <label>学号：</label>
                <input type="text" class="form-control" v-model="student.studentno">
            </div>
            <div class="form-group">
                <label>小组号：</label>
                <select class="form-control" v-model="student.groupid">
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
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>

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
                studentname:"",
                studentno: Number(),
                groupid: Number()
            }
        },
        methods: {
            //学生注册
            PostStudent(){
                if (this.student.groupid !=''&&this.studentno!=''){
                    var student = {
                        studentno: Number(this.student.studentno),
                        studentname: "bupt"+this.student.studentname,
                        groupid: Number(this.student.groupid),
                        teachername: '<%=loginUser.getUsername()%>',
                        speeches: Number(0),
                        logins:Number(0)
                    }
                    this.$http.post("addstudenttogroupservlet",JSON.stringify(student)).then(function (data) {
                        console.log(student)
                        this.LoadStudents()
                    })
                }
            },
            //学生加载
            LoadStudents(){
                this.$http.get("showgroupsservlet").then(function(data){
                    this.groups=data.body[0];
                    console.log(this.groups);
                    console.log(sortByKey(this.groups,'groupid'))
                })
            }
        },
        computed:{
            // //学生排序
            // sortStudent: function (array){
            //     console.log(array)
            //     return sortByKey(array, 'groupid');//将studet数组中的数据按照年龄进行排序
            // }
        },
        created(){
            this.LoadStudents();
        }

    })
    //数组对象方法排序:
    function sortByKey(array, key) {
        return array.sort(function (a, b) {
            console.log(key)
            var x = a[key];
            var y = b[key];
            return ((x < y) ? -1 : ((x > y) ? 1 : 0));
        });
    }
</script>
</body>
</html>
