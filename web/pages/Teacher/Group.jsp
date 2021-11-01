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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="static/css/style-checkbox.css">
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
<%--引入导航栏--%>
<%@include file="headleader.jsp"%>
<%--从session中获得user    --%>
<div class="app">
    <div id="GroupManager">
        <div style="overflow-y: scroll;max-height: 800px">
        <%--添加独立的学生--%>
            <br/>
            <button class="butt" @click="show()">添加独立学生</button>
            <br/>
            <br/>
            <transition>
                <div class="mask" v-if="mask" @click="close()">
                    <%--click.stop阻止冒泡        --%>
                    <div class="box" @click.stop="">
                        <div v-for="(student,index) in ThatStudents">
                            <input :id="student.studentno" :value="student.studentno" type="checkbox" value="student.studentno" v-model="inviteStudents"/>
                            <label :for="student.studentno">学生{{student.studentname}}</label>
                            <div class="form-group" v-show="showGroup(student.studentno)">
                                <label>小组号：</label>
                                <select typeof="checkbox" class="form-control"  v-model="student.groupid">
                                    <option value=1>1</option>
                                    <option value=2>2</option>
                                    <option value=3>3</option>
                                    <option value=4>4</option>
                                    <option value=5>5</option>
                                    <option value=6>6</option>
                                    <option value=7>7</option>
                                    <option value=8>8</option>
                                    <option value=9>9</option>
                                    <option value=10>10</option>
                                    <option value=11>11</option>
                                    <option value=12>12</option>
                                    <option value=13>13</option>
                                    <option value=14>14</option>
                                    <option value=15>15</option>
                                    <option value=16>16</option>
                                    <option value=17>17</option>
                                    <option value=18>18</option>
                                    <option value=19>19</option>
                                    <option value=20>20</option>
                                    <option value=21>21</option>
                                    <option value=22>22</option>
                                    <option value=23>23</option>
                                    <option value=24>24</option>
                                    <option value=25>25</option>
                                    <option value=26>26</option>
                                    <option value=27>27</option>
                                    <option value=28>28</option>
                                    <option value=29>29</option>
                                    <option value=30>30</option>
                                    <option value=31>31</option>
                                    <option value=32>32</option>
                                    <option value=33>33</option>
                                    <option value=34>34</option>
                                    <option value=35>35</option>
                                    <option value=36>36</option>
                                    <option value=37>37</option>

                                </select>
                            </div>
                        </div>
                        <button class="butt" @click="Sent()"></span>添加</button>
                    </div>

                </div>
            </transition>
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
                    <option value=1>1</option>
                    <option value=2>2</option>
                    <option value=3>3</option>
                    <option value=4>4</option>
                    <option value=5>5</option>
                    <option value=6>6</option>
                    <option value=7>7</option>
                    <option value=8>8</option>
                    <option value=9>9</option>
                    <option value=10>10</option>
                    <option value=11>11</option>
                    <option value=12>12</option>
                    <option value=13>13</option>
                    <option value=14>14</option>
                    <option value=15>15</option>
                    <option value=16>16</option>
                    <option value=17>17</option>
                    <option value=18>18</option>
                    <option value=19>19</option>
                    <option value=20>20</option>
                    <option value=21>21</option>
                    <option value=22>22</option>
                    <option value=23>23</option>
                    <option value=24>24</option>
                    <option value=25>25</option>
                    <option value=26>26</option>
                    <option value=27>27</option>
                    <option value=28>28</option>
                    <option value=29>29</option>
                    <option value=30>30</option>
                    <option value=31>31</option>
                    <option value=32>32</option>
                    <option value=33>33</option>
                    <option value=34>34</option>
                    <option value=35>35</option>
                    <option value=36>36</option>
                    <option value=37>37</option>
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
            inviteStudents:[],
            mask:false,
            ThatStudents:[{studentname:"张一",studentno:2,groupid:NaN},
                {studentname:"张二",studentno:1,groupid:NaN},
                {studentname:"张三",studentno:3,groupid:NaN}],
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
            //弹窗逻辑部分
            show(){
              this.mask=!this.mask;
            },
            close(){
                this.mask=!this.mask;
            },
            Sent(){
               var Package=[];
                for (i=0;i<this.inviteStudents.length;i++){
                    for (j=0;j<this.ThatStudents.length;j++){
                        if (this.inviteStudents[i]==this.ThatStudents[j].studentno){
                            Package.push({studentno:this.ThatStudents[j].studentno,groupid:this.ThatStudents[j].groupid});
                        }
                    }
                }
                console.log(Package);
            },
            showGroup(studentno){
                id = "#"+studentno;
                return  $(id).prop("checked")
            },
            //学生注册
            PostStudent(){
                if (this.student.groupid !=''&&this.studentno!='') {
                    var student = {
                        studentno: Number(this.student.studentno),
                        studentname: "bupt" + this.student.studentname,
                        groupid: Number(this.student.groupid),
                        teachername: '<%=loginUser.getUsername()%>',
                        speeches: Number(0),
                        logins: Number(0)
                    }
                    this.$http.post("addstudenttogroupservlet", JSON.stringify(student)).then(function (data) {
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
<%--尾部--%>
<%@include file="../Public/footer.jsp"%>
</body>
</html>
