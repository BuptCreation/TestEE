<%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/7/18
  Time: 11:31 上午
  To change this template use File | Settings | File Templates.
--%>
<%--最上面一行为page指令 可以修改html页面中的一些重要属性或行为--%>
<%--常用属性
  1。language jsp翻译后是什么语言文件 暂时只支持java（0。。0）
  2。contenttype表示返回的数据类型是什么
  3。import属性则是和java源代码一样用来导入包导入类的
  ——————————————以下两个属性是给out输出柳使用的————————————————————
  4。autoFlush属性  设置党out输出缓冲区满了后是否自动刷新缓冲 默认true
  5。buffer属性    设置out缓冲区大小 默认8kb

  6。errorPage 属性 设置当jsp页面运行出错时，自动跳转去的页面路径 该路径为工程路径
  7。isErrorPage属性 设置当前jsp是否是错误页面 如果是true  则可获取他的错误信息
  8.session属性 是否创建session属性
  9。extends属性 设置jsp翻译出来的java类默认继承谁    //最好不改 非默认继承的类一般无法实现对应功能
--%>

<%--可以声明脚本    这种情况用的极少--%>
<%--可以给jsp翻译出来的java类定义属性和方法甚至是静态类
可定义类属性
可定义代码块
可声明类方法
可声明内部类
--%>


<%--另一种脚本 表达式脚本的格式是 <%=%>表达式%>--%>
<%--表达式脚本的作用是在jsp页面上输出数据
表达式脚本的特点：
所有的表达式脚本都会翻译到jspService方法中 且记住 表达式脚本经常会用到
且都会被翻译成为out。print输出到页面上
由于表达式脚本翻译的内容都在jspService（）方法中，所以jsp中的对象等都能直接使用
在表达式脚本中表达式语句结尾不能用分号结束
--%>


<%--代码脚本
格式
<%
  java语句
  %>
  代码脚本的作用是：可以在jsp页面中，编写我们自己需要的功能（写的是java语句）

  可以写
  if
  for

  由于代码脚本翻译的内容都在jspService（）方法中，所以jsp中的对象等都能直接使用
  代码脚本还可以由多个代码脚本块组合完成一个完整的java语句
  代码脚本还可以和表达式脚本一起组合使用，在jsp页面上输出数据
--%>
<%--jsp注释， html注释，java注释 都能发挥对应的作用--%>

<%--jsp九大内置对象   是指tomcat在翻译jsp页面成为servlet源代码后 提供的九大内置对象
request  请求对象
response 相应对象
pageContext jsp的上下文对象
session 会话对象
application ServletContext对象
config    ServletConfig对象
out  jsp输出流对象
page 指向当前jsp对象
--%>

<%--四个域对象
PageContext（pageContextimpl） 当前jsp范围有效
request(HttpServletRequest类)，一次请求有效
session(HttpSession)          一个会话范围内有效
application(servletContext类)  整个web工程范围内都有效

域对象可以像Map一样存取数据的对象。四个域对象功能一样。不同的是他们对数据的存取范围
--%>

<%--jsp out 和response的区别--%>

<%--记住在jsp中使用out输出 如out。write和out。print--%>

<%--静态页面 （不变的部分）一个单独的jsp页面 只维护一份，改一处，其他统一被修改 其他页面可以引入该页面--%>
<%----%>

<%--  Created by IntelliJ IDEA.--%>
<%--  User: tigers--%>
<%--  Date: 2021/8/7--%>
<%--  Time: 3:02 下午--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
  <title>研讨区</title>
  <!--    基础路径-->
  <base href="../../">
  <!--引入样式表-->
  <link href="https://cdn.staticfile.org/quill/1.3.6/quill.snow.css" rel="stylesheet">
  <!-- 引入Quill -->
  <script src="https://cdn.staticfile.org/quill/1.3.6/quill.js"></script>

  <!--    vue-基础包导入-->
  <script src="static/vue/vue.js" type="text/javascript" charset="utf-8"></script>
  <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
  <!--    vue-resource 包导入-->
  <script src="https://cdn.bootcdn.net/ajax/libs/vue-resource/1.5.3/vue-resource.js"></script>
  <!--    vue 路由功能导入-->
  <script src="https://cdn.staticfile.org/vue-router/2.7.0/vue-router.min.js"></script>
  <%--jquery包    --%>
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
  <%-- bootstrap布局导入   --%>
  <link rel="stylesheet" href="static/css/bootstrap.css">
</head>
<style>
  <%--    美化排版--%>
  .User{
    padding: 7px;
    float: left;
  }
  .UState{
    padding: 7px;
    float: right;
  }
  .Prompt{
    padding: 7px;
    align-content: center;
    color: lightskyblue;
  }
  .bubble-left span{
    float: left;
    background-color: #999999;
    padding: 5px 8px;
    display: inline-block;
    border-radius: 4px;
    margin:10px 0 10px 10px;
    position: relative;

  }
  .bubble-left span::after{
    content: '';
    border: 8px solid #ffffff00;
    border-right: 8px solid #999999;
    position: absolute;
    top: 6px;
    left: -16px;
  }
  .bubble-right span{
    white-space: pre-line;
    float: right;
    background-color: #c6feeb;
    padding: 5px 8px;
    display: inline-block;
    border-radius: 4px;
    margin:10px 0 10px 10px;
    position: relative;
    right: 16px;
  }
  .bubble-right span::after{
    content: '';
    border: 8px solid #ffffff00;
    border-left: 8px solid #c6feeb;
    position: absolute;
    top: 6px;
    right: -16px;
  }
  .submit {
    border: none;
    color: white;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    background-color: white;
    color: black;
    border: 2px solid #008CBA;
  }

  .submit:hover {
    background-color: #008CBA;
    color: white;
  }
  <%--    格式排版--%>
  #contains{
    background-color: #666666;
    width: 1000px;
    height: 700px;
    margin: auto;
  }
  #username{
    color: #ecf0f1;
    background-color: #666666;
    width: 1000px;
    height: 40px;
    border-radius: 50px 50px 0px 0px;
  }
  #Inchat{
    text-align: center;
    background-color: #666666;
    width: 1000px;
    height: 50px;
  }
  #left{
    border: 1px solid #8c8c8c;
    background-color: white;
    width: 700px;
    height: 640px;
    float: left;
    position: relative;
  }
  #content{
    border: 1px solid #8c8c8c;
    background-color: white;
    width: 700px;
    height: 400px;
    /*display: none;*/
    visibility: hidden;
    overflow-y: scroll;
  }
  #right{
    border: 1px solid #8c8c8c;
    background-color: #ecf0f1;
    width: 300px;
    height: 640px;
    float: right;
  }
  #hyList{
    border: 1px solid #8c8c8c;
    height: 270px;
    overflow-y: scroll;
    background: antiquewhite;
  }
  #xtList{
    border: 1px solid #8c8c8c;
    height: 270px;
    overflow-y: scroll;
    background: antiquewhite;
  }
  #input{
    border: 1px solid #8c8c8c;
    margin-bottom: 0px;
    position: absolute;
    bottom: 0px;
  }
  #mes_left{
    float: left;
    border: 2px aqua;
    max-width: 490px;
  }
  #mes_right{
    float: right;
    border: 2px aqua;
    max-width: 490px;
  }
  #hy{
    display: block;
    width: 300px;
  }
  textarea {
    resize: none;
    border: none;
    outline: none
  }
</style>
<body>
<br/>
<br/>
<div id = "contains">
  <div id="username">
    <div class="User"><h3>用户:</h3></div>
    <div class="UState">服务器未连接到终端</div>
  </div>

  <div id="Inchat">

    <div class="Prompt">没有聊天对象</div>
  </div>
  <div id="left">
    <%--    聊天展示区    --%>
    <div id="content">

    </div>
    <%--输入区--%>
    <div id="input">
<%--      <textarea type="text" id="input_text" style="width: 695px;height: 200px;"></textarea>--%>
      <div id="editor" style="width: 695px;height: 200px;"></div>
      <button id="submit" class="submit" style="float: right;">发送</button>
    </div>
  </div>
  <div id="right">
    <p id="hy" style="text-align: center;">好友列表</p>
    <a style="text-align: center;display: block" onclick='showGroupChat()'>小组聊天室</a></br>
    <div id="hyList">

    </div>
    <p id="xt" style="text-align: center">系统消息</p>
    <div id="xtList">

    </div>
  </div>
</div>
<br/>
<br/>
</body>
<%--jquery管理区域--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
  var Count=0;
  var toName;
  var username;
  var Group=true;
  var UserGroup="1teacher168";//未初始化
  var isMe=false;
  //富文本编辑器
  var quill = new Quill('#editor', {
    theme: 'snow'
  });
  //点击好友名称展示相关消息
  window.onbeforeunload = function(event) {
    var count = {count:Count,id:Number()};
    $.post("updatecountservlet",JSON.stringify(count)).then(function(data) {
      console.log(data);
    });
    //count归零
    Count=0;
  };
  function showChat(name){
    Group=false;
    toName = name;
    //现在聊天框
    //立刻清空聊天框
    $("#content").html("");
    $("#content").css("visibility","visible");
    $("#Inchat").html("<div class=\"Prompt\">当前正与"+toName+"聊天</div>");
    //从sessionStorage中获取历史信息
    var chatData = sessionStorage.getItem(toName);
    if (chatData != null){
      $("#content").html(chatData);
    }
  }
  function showGroupChat(name){
    Group=true;
    //现在聊天框
    //立刻清空聊天框
    $("#content").html("");
    $("#content").css("visibility","visible");
    $("#Inchat").html("<div class=\"Prompt\">当前正与"+"组内所有成员"+"聊天</div>");
    //从sessionStorage中获取群聊的历史信息
    var chatData = sessionStorage.getItem(UserGroup);
    if (chatData != null){
      $("#content").html(chatData);
    }
  }
  $(function () {
    $.ajax({
      //从getUsername处获得用户名
      url:"getUsername",
      type:"get",
      //成功后的回调函数
      <%
  java.lang.String keyGroup = (java.lang.String)request.getSession().getAttribute("KeyGroup");
%>
      success:function (res) {
        username = res;
        UserGroup =  "<%=keyGroup%>";
      },
      async:false //同步请求，只有上面好了才会接着下面
    });
    //建立websocket连接
    //获取host解决后端获取httpsession的空指针异常
    var host = window.location.host;
    var ws = new WebSocket("ws://"+"localhost:8080/BuptCreationEE_war_exploded"+"/chat");
    //建立连接之后
    ws.onopen = function (evt) {
      //在建立连接之后 需要做什么?
      $("#username").html("<div class=\"User\"><h3>用户:"+username+"</h3></div><div class=\"UState\" style=\"color: lawngreen \"><h3>在线</h3></div>");
    }
    //接受消息后进行触发
    ws.onmessage = function (evt) {
      //获取服务端推送的消息
      var dataStr = evt.data;
      //将dataStr转换为json对象
      var res = JSON.parse(dataStr);
      console.log("得到消息");
      //判断是否是系统消息
      if(res.system){
        //系统消息
        //1.好友列表展示
        //2.系统广播的展示
        //此处声明的变量是调试时命名的，可以直接合并
        var names = res.message;
        var userlistStr = "";
        var broadcastListStr = "";
        var temp01 = "<a style=\"text-align: center; display: block;\" onclick='showChat(\"";
        var temp03 = "\")'>";
        var temp04 = "</a></br>";
        var temp = "";
        for (var name of names){
          if (name != username){
            temp = temp01 + name + temp03 + name + temp04;
            userlistStr = userlistStr + temp;
            broadcastListStr += "<p style='text-align: center'>"+ name +"上线了</p>";
          }
        }
        console.log("系统消息"+userlistStr);
        //渲染好友列表和系统广播
        $("#hyList").html(userlistStr);
        $("#xtList").html(broadcastListStr);

      }else {
        //不是系统消息
        //判断是否是小组消息
        if(res.group==true){
          var str = "<div class=\"bubble-left\"><span>" + res.message + "</span></div></br></br></br>";
          //如果消息就刚好是给我们组发消息的人
          if (UserGroup == res.keyGroup) {
            if (isMe==true) {
              isMe=false;
            }else {
              $("#content").append(str);
            }
          }
          var chatData = sessionStorage.getItem(res.keyGroup);
          if (chatData != null) {
            str = chatData + str;
          }
          //保存聊天消息
          console.log("保存小组"+res.keyGroup+"的消息"+str);
          sessionStorage.setItem(res.keyGroup, str);
        }else {
          var str = "<div class=\"bubble-left\"><span>" + res.message + "</span></div></br></br></br>";
          //如果消息就刚好是给我发消息的人
          if (toName === res.fromName) {
            $("#content").append(str);
          }
          var chatData = sessionStorage.getItem(res.fromName);
          if (chatData != null) {
            str = chatData + str;
          }
          //保存聊天消息
          console.log("保存个人"+res.fromName+"的消息"+res);
          sessionStorage.setItem(res.fromName, str);
        }
      };
    }
    ws.onclose = function () {
      //发送数据给后台统计

      <%--var count = {count:Count,id:Number(<%=loginUser.getStudentNo()%>)};--%>
      <%--$.post("https://jsonplaceholder.typicode.com/posts/",JSON.stringify(count)).then(function(data) {--%>
      <%--     console.log(data);--%>
      <%--});--%>
      <%--    //count归零--%>
      <%--    Count=0;--%>
      $("#username").html("<div class=\"User\"><h3>用户:"+username+"</h3></div><div class=\"UState\" style=\"color: orangered \"><h3>离线</h3></div>");
    }

    //发送消息
    $("#submit").click(function () {
      //0.说话次数加一
      Count+=1;
      //1.获取输入的内容
      var data = quill.getText();
      //2.清空发送框
      quill.deleteText();
      if (Group==false) {
        console.log("发送消息给个人")
        var json = {"toName": toName, "message": data,"group":false};
        //将数据展示在聊天区
        var str = "<div class=\"bubble-right\"><span>" + data + "</span></div></br></br></br>";
        $("#content").append(str);
        //将聊天记录存储到局部寄存器

        var chatData = sessionStorage.getItem(toName);
        if (chatData != null) {
          str = chatData + str;
        }
        sessionStorage.setItem(toName, str);
      }else {
        console.log("消息发送给小组");
        var json = {"toName":UserGroup, "message": data,"group":true};
        //将数据展示在聊天区
        console.log(json);
        var str = "<div class=\"bubble-right\"><span>" + data + "</span></div></br></br></br>";
        $("#content").append(str);
        //将聊天记录存储到局部寄存器

        var chatData = sessionStorage.getItem(UserGroup);
        if (chatData != null) {
          str = chatData + str;
        }
        sessionStorage.setItem(UserGroup, str);
        isMe=true;
      }
      //3.发送数据
      ws.send(JSON.stringify(json));
    })
  })
</script>
<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
<!--小帅哥： https://unpkg.com/live2d-widget-model-chitose@1.0.5/assets/chitose.model.json-->
<!--萌娘：https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json-->
<!--小可爱（女）：https://unpkg.com/live2d-widget-model-koharu@1.0.5/assets/koharu.model.json-->
<!--小可爱（男）：https://unpkg.com/live2d-widget-model-haruto@1.0.5/assets/haruto.model.json-->
<!--初音：https://unpkg.com/live2d-widget-model-miku@1.0.5/assets/miku.model.json-->
<!-- 上边的不同链接显示的是不同的小人，这个可以根据需要来选择 下边的初始化部分，可以修改宽高来修改小人的大小，或者是鼠标移动到小人上的透明度，也可以修改小人在页面出现的位置。 -->
<script>
  /*https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json*/
  L2Dwidget.init({ "model": { jsonPath:
              "https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json",
      "scale": 1 }, "display": { "position": "right", "width": 210, "height": 250,
      "hOffset": 0, "vOffset": -20 }, "mobile": { "show": true, "scale": 0.5 },
    "react": { "opacityDefault": 0.8, "opacityOnHover": 0.1 } });
</script>
</html>
