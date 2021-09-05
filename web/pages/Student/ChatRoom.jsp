<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/8/7
  Time: 3:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研讨区</title>
    <!--    基础路径-->
    <base href="../../">
    <%--聊天室表情包导入--%>
    <link rel="stylesheet" href="static/css/chat-style.css">
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
    <%--样式模版导入    --%>
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,500,500i,700" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel='stylesheet'
          href='https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css'>
    <link rel="stylesheet" href="static/css/chat_remainder.css">
    <%--at包导入    --%>
    <link rel="stylesheet" href="static/css/jqueryAtwho.css"/>
    <%--    <link rel="stylesheet" href="pages/Student/atwho.css" />--%>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://ichord.github.io/Caret.js/src/jquery.caret.js"></script>
    <%--标签样式    --%>
    <link href="https://fonts.googleapis.com/css?family=Sen:400,700,800&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/cb2ec89b0c.js" crossorigin="anonymous"></script>
    <style type="text/css">
        /*override atwho's style*/
        .atwho-inserted {
            color: #4183C4;
        }

        .atwho-query {
            color: #4183C4;
        }
    </style>
</head>
<style>
    <%--    美化排版--%>
    footer {

    }

    .User {
        padding: 7px;
        float: left;
    }

    .UState {
        padding: 7px;
        float: right;
    }

    .Prompt {
        padding: 7px;
        align-content: center;
        color: lightskyblue;
    }

    .bubble-left span {
        float: left;
        background-color: #999999;
        padding: 5px 8px;
        display: inline-block;
        border-radius: 4px;
        margin: 10px 0 10px 10px;
        position: relative;

    }

    .bubble-left span::after {
        content: '';
        border: 8px solid #ffffff00;
        border-right: 8px solid #999999;
        position: absolute;
        top: 6px;
        left: -16px;
    }

    .bubble-right span {
        white-space: pre-line;
        float: right;
        background-color: #c6feeb;
        padding: 5px 8px;
        display: inline-block;
        border-radius: 4px;
        margin: 10px 0 10px 10px;
        position: relative;
        right: 16px;
    }

    .bubble-right span::after {
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
        width: 70%;
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
        border-radius: 5px;
    }

    .submit:hover {
        background-color: #008CBA;
        color: white;
    }

    #input_text {
        width: 690px;
    }
    #editable:before
    {
        content:"@区域:";
    }
    <%--    格式排版--%>
    #contains {
        background-color: #8c8c8c;
        width: 1000px;
        height: 700px;
        margin: auto;
        border-radius: 5px;
    }

    #username {
        color: #ecf0f1;
        background-color: #8c8c8c;
        width: 1000px;
        height: 40px;
        border-radius: 50px 50px 0px 0px;
    }

    #Inchat {
        text-align: center;
        background-color: #8c8c8c;
        width: 1000px;
        height: 50px;
    }

    #left {
        border: 1px solid #8c8c8c;
        background-color: white;
        width: 700px;
        height: 640px;
        float: left;
        position: relative;
    }

    #content {
        border: 1px solid #8c8c8c;
        background-color: white;
        width: 700px;
        height: 400px;
        /*display: none;*/
        visibility: hidden;
        overflow-y: scroll;
    }

    #right {
        border: 1px solid #8c8c8c;
        background-color: #ecf0f1;
        width: 300px;
        height: 640px;
        float: right;
    }

    #hyList {
        border: 1px solid #8c8c8c;
        height: 270px;
        overflow-y: scroll;
        background: whitesmoke;
    }

    #xtList {
        border: 1px solid #8c8c8c;
        height: 270px;
        overflow-y: scroll;
        background: whitesmoke;
    }

    #input {
        width: 700px;
        border: 1px solid #8c8c8c;
        margin-bottom: 0px;
        position: absolute;
        bottom: 0px;
    }

    #mes_left {
        float: left;
        border: 2px aqua;
        max-width: 490px;
    }

    #mes_right {
        float: right;
        border: 2px aqua;
        max-width: 490px;
    }

    #hy {
        display: block;
        width: 300px;
    }

    textarea {
        resize: none;
        border: none;
        outline: none
    }
    .others {
        display: flex;
        background-color: #fff;
        position: absolute;
        top: 180px;
        z-index: -1;
        border-radius: 999px;
        box-shadow: 0 0 25px -5px lightgray;
        transition: 0.3s all ease-out;
    }
    .emoji-button {
        position: relative;
        /*display: none;*/
        /*position: absolute;*/
        top: 0px;
        right: 0px;
        transition: 0.3s all ease-out;
        user-select: none;
        cursor: pointer;
        margin-right: 5px;
        margin-bottom: 5px;
        width: 20px;
        height: 20px;
    }
    .emoji{
        position: relative;
        display: none;
        /*position: absolute;*/
        top: 0px;
        right: 0px;
        transition: 0.3s all ease-out;
        user-select: none;
        cursor: pointer;
        margin-right: 5px;
        margin-bottom: 5px;
        width: 20px;
        height: 20px;
    }
    .button-add{
        border: none;
        color: white;
        width: 20%;
        padding: 8px 16px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 30px;
        margin: 4px 2px;
        -webkit-transition-duration: 0.4s; /* Safari */
        transition-duration: 0.4s;
        cursor: pointer;
        background-color: white;
        color: black;
    }
    .others-show {
        top: 140px !important;
        z-index: 10 !important;
    }

    .emoji-show {
        display: flex !important;
        flex-wrap: wrap;
        align-content: flex-start;
        width: 300px !important;
        height: 100px; !important;
        overflow-y: scroll;
        padding: 10px;
        top: -135px !important;
        right: 10px !important;
        background-color: #fff;
        box-shadow: 0 0 25px -5px lightgray;
        border-radius: 5px 5px 0 5px;
    }
</style>
<body>
<%@include file="headleader.jsp" %>
<br/>
<br/>
<%
    User loginUser = (User) request.getSession().getAttribute("User");
%>
<%--消息提示区以及背景切换区域，以下--%>
<input class="variation" id="bluepurple" type="radio" value="1" name="color" checked="checked"/>
<label for="bluepurple"></label>
<input class="variation" id="sunset" type="radio" value="2" name="color"/>
<label for="sunset"></label>
<input class="variation" id="godiva" type="radio" value="3" name="color"/>
<label for="godiva"></label>
<input class="variation" id="dark" type="radio" value="4" name="color"/>
<label for="dark"></label>
<input class="variation" id="pinkaru" type="radio" value="5" name="color"/>
<label for="pinkaru"></label>
<main>
    <section class="alerts">
        <h6>消息提示</h6>
        <div class="alert status-primary">点击小组聊天室 进行群聊功能.</div>
        <div class="alert status-secondary">输入框的上方框框专为at设计 请在此完成at的所有功能.</div>
        <div class="alert status-info">聊天表情可以增加,at提示会出现这儿</div>
        <div class="alert status-success">点击我们，我们会消失.</div>
        <div class="alert status-error">数据库未归档，注意归档.</div>
    </section>
</main>
<%--以上--%>
<div id="contains">
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
            <%--            <textarea type="text" id="input_text" style="width: 695px;height: 200px;"></textarea>--%>
            <div id="main">
              <div id="editable" class="inputor" contentEditable="true" style="text-align: left"></div>
            </div>
            <div id="app">
                <!-- emojis start -->
<%--                <div class="emoji">--%>
<%--                    <div class="emoji-list">--%>
<%--                        <section v-for="(key, keyIndex) in Object.keys(emoji)" :key="keyIndex">--%>
<%--          <span class="emoji-list-item" v-for="(item, index) in emoji[key]" :key="index" @click="insertEmoji(item)">--%>
<%--            {{item}}--%>
<%--          </span>--%>
<%--                        </section>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <!-- emojis end -->

                <!-- editor start -->
                <div
                        class="editor"
                        contenteditable="true"
                        ref="editor"
                        @keyup="getCursor"
                        @keydown.enter.prevent="submit"
                        @paste.prevent="onPaste"
                        @click="getCursor"
                        id="input_text" style="text-align: left">
                </div>
                <!-- editor end -->
<%--               发送按钮 --%>
            <button id="submit" class="submit" style="float: right;">发送</button>

<%--      功能扩展按钮--%>
            <%--以下--%>
                <span class="button-add">
                    <i class="fas fa-plus-circle"></i>
                        <div class="others ">
                            <div class="emoji-button" style="margin: 10px">
                                <i class="far fa-laugh"></i>
                            <div class="emoji">
                                <div class="emoji-list">
                                    <section v-for="(key, keyIndex) in Object.keys(emoji)" :key="keyIndex">
                                        <span class="emoji-list-item" v-for="(item, index) in emoji[key]" :key="index" @click="insertEmoji(item)">
                                        {{item}}
                                        </span>
                                    </section>
                                </div>
                            </div>
                            </div>
                             <span class="image-button" style="margin: 10px">
                            <i class="far fa-image"></i>
                            </span>
                            <span>
                            <i class="fas fa-paperclip" style="margin: 10px"></i>
                            </span>
                        </div>
                </span>
            </div>
            <%--以上，测试数据            --%>
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
    <footer>

    </footer>
</div>
<br/>
<br/>
</body>
<%--jquery管理区域--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    var Count = 0;
    var toName;
    var username;
    var Group = true;
    var UserGroup = "1teacher168";//未初始化
    var isMe = false;
    //心跳连接以及状态判定
    var websocket_connected_count = 0;
    var onclose_connected_count = 0;
    //点击好友名称展示相关消息
    window.onbeforeunload = function (event) {
        var count = {count: Count, id: Number(<%=loginUser.getStudentNo()%>)};
        $.post("updatecountservlet", JSON.stringify(count)).then(function (data) {
            console.log(data);
        });
        // var allchat = sessionStorage.getItem(UserGroup);
        //
        // $.post("saveallchatservlet", JSON.stringify(allchat)).then(function (data) {
        //     console.log("Data: " + allchat);
        // });
        //count归零
        Count = 0;
    };

    function showChat(name) {
        Group = false;
        toName = name;
        //现在聊天框
        //立刻清空聊天框
        $("#content").html("");
        $("#content").css("visibility", "visible");
        $("#Inchat").html("<div class=\"Prompt\">当前正与" + toName + "聊天</div>");
        //从sessionStorage中获取历史信息
        var chatData = sessionStorage.getItem(toName);
        if (chatData != null) {
            $("#content").html(chatData);
        }
    }

    function showGroupChat(name) {
        Group = true;
        //现在聊天框
        //立刻清空聊天框
        $("#content").html("");
        $("#content").css("visibility", "visible");
        $("#Inchat").html("<div class=\"Prompt\">当前正与" + "组内所有成员" + "聊天</div>");
        //从sessionStorage中获取群聊的历史信息
        var chatData = sessionStorage.getItem(UserGroup);
        if (chatData != null) {
            $("#content").html(chatData);
        }
    }

    //the alert is collapsible yay
    $(".alert").on("click", function () {
        $(this).hide("slow");
    });
    //apprearance
    $("input.variation").on("click", function () {
        if ($(this).val() > 3) {
            $("body").css("background", "#2a313b");
            $("footer").attr('class', 'dark');
        } else {
            $("body").css("background", "#f9f9f9");
            $("footer").attr('class', '');
        }
    });
    $(function () {
        $(".button-add").click(function(){
            console.log("button-add已经被点击")
            if ( $(".others").hasClass("others-show")){
                $(".others").removeClass("others-show")
            }else {
                $(".others").addClass("others-show")
            }
        });
        $(".emoji-button").click(function () {
            console.log("emoji-button已经被点击")
            if ($(".emoji").hasClass("emoji-show")){
                $(".emoji").removeClass("emoji-show")
            }else {
                $(".emoji").addClass("emoji-show")
            }
            return false;
        })
        $.ajax({
            //从getUsername处获得用户名
            url: "getUsername",
            type: "get",
            //成功后的回调函数
            <%
        String keyGroup = (String)request.getSession().getAttribute("KeyGroup");
    %>
            success: function (res) {
                username = res;
                UserGroup = "<%=keyGroup%>";
            },
            async: false //同步请求，只有上面好了才会接着下面
        });
        var tags = ["wzg168"];
        //建立websocket连接
        //获取host解决后端获取httpsession的空指针异常
        var jeremy = decodeURI("J%C3%A9r%C3%A9my") // Jérémy
        // $.get("getgroupmemberservlet").then(function (data) {
        //     $('#editable').atwho(data=data);
        //     console.log(tags);
        // })
        $('#editable').atwho({
            at: "@",
            data: "getgroupmemberservlet",
            limit: 200,
            <%--tpl:'<span data-id="${id}">@${name}</span>',--%>
            callbacks: {
                afterMatchFailed: function (at, el) {
                    // 32 is spacebar
                    if (at == '@') {
                        tags.push(el.text().trim().slice(1));
                        this.model.save(tags);
                        this.insert(el.text().trim());
                        return false;
                    }
                }
                // matcher: function (flag, subtext) {
                //     var match, regexp, _a, _y;
                //     flag = flag.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&");
                //     _a = decodeURI("%C3%80");
                //     _y = decodeURI("%C3%BF");
                //     regexp = new RegExp("" + flag + "([A-Za-z" + _a + "-" + _y + "0-9_\+\-]*)$|" + flag + "([^\\x00-\\xff]*)$", 'gi');
                //     match = regexp.exec(subtext);
                //     if (match) {
                //         return match[2] || match[1];
                //     } else {
                //         return null;
                //     }
                // }
            }
        });
        var host = window.location.host;
        // var ws = new WebSocket("ws://"+"localhost:8080/BuptCreationEE_war_exploded"+"/chat");
        var ws = new WebSocket("ws://" + "47.94.108.20:8080/BuptCreationEE" + "/chat");
        //建立连接之后
        ws.onopen = function (evt) {
            // 成功建立连接后，重置心跳检测
            heartCheck.reset().start();
            //在建立连接之后 需要做什么?
            $("#username").html("<div class=\"User\"><h3>用户:" + username + "</h3></div><div class=\"UState\" style=\"color: lawngreen \"><h3>在线</h3></div>");
        }
        //接受消息后进行触发
        ws.onmessage = function (evt) {
            // 如果获取到消息，说明连接是正常的，重置心跳检测
            heartCheck.reset().start();
            //获取服务端推送的消息
            var dataStr = evt.data;
            //将dataStr转换为json对象
            var res = JSON.parse(dataStr);
            console.log("得到消息");
            //判断是否是系统消息
            if (res.system) {
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
                //at数据
                // $('#editable').atwho({data:names});

                for (var name of names) {

                    if (name != username) {
                        temp = temp01 + name + temp03 + name + temp04;
                        userlistStr = userlistStr + temp;
                        broadcastListStr += "<p style='text-align: center'>" + name + "上线了</p>";
                    }
                }
                console.log("系统消息" + userlistStr);
                //渲染好友列表和系统广播
                $("#hyList").html(userlistStr);
                $("#xtList").html(broadcastListStr);

            } else {
                //不是系统消息
                //判断是否是小组消息
                if (res.group == true) {
                    //处理小组消息内容
                    console.log(res.keyGroup + "at" + res.atwhos);
                    var at = "";
                    for (var i = 0; i < res.atwhos.length; i++) {
                        at += "<div style='color:lightskyblue;display: inline'>@" + res.atwhos[i] + "</div>";
                    }
                    var str = "<div class=\"bubble-left\"><span>" + res.sender + "说:" + at + res.message + "</span></div></br></br></br>";
                    //如果消息就刚好是给我们组发消息的人
                    if (UserGroup == res.keyGroup) {
                        //处理at广播
                        if (res.at == true) {
                            var atmessage = "";
                            for (var i = 0; i < res.atwhos.length; i++) {
                                //     <div class="alert status-primary">A normal alert here.</div>
                                //     <div class="alert status-secondary">A normal alert here.</div>
                                // <div class="alert status-info">A normal alert here.</div>
                                // <div class="alert status-success">A happy alert here.</div>
                                // <div class="alert status-error">A sad alert here.</div>
                                if (res.atwhos[i] == username) {
                                    var alter = "<div class=\"alert status-info\">" + res.atwhos[i] + "被" + res.sender + "at了" + "</div>";
                                } else {
                                    var alter = "<div class=\"alert status-primary\">" + res.atwhos[i] + "被" + res.sender + "at了" + "</div>";
                                }
                                $(".alerts").append(alter);
                            }
                            $(".alert").on("click", function () {
                                $(this).hide("slow");
                            });
                        }
                        if (isMe == true) {
                            isMe = false;
                            return
                        } else {
                            $("#content").append(str);
                        }
                    }
                    var chatData = sessionStorage.getItem(res.keyGroup);
                    if (chatData != null) {
                        str = chatData + str;
                    }
                    //保存聊天消息
                    console.log("保存小组" + res.keyGroup + "的消息" + str);
                    sessionStorage.setItem(res.keyGroup, str);

                } else {
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
                    console.log("保存个人" + res.fromName + "的消息" + res);
                    sessionStorage.setItem(res.fromName, str);
                }
            }
            ;
        }
        ws.onclose = function () {
            //发送数据给后台统计

            <%--var count = {count:Count,id:Number(<%=loginUser.getStudentNo()%>)};--%>
            <%--$.post("https://jsonplaceholder.typicode.com/posts/",JSON.stringify(count)).then(function(data) {--%>
            <%--     console.log(data);--%>
            <%--});--%>
            <%--    //count归零--%>
            <%--    Count=0;--%>
            <%--关闭时获取寄存器中的所有数据,发送--%>
            $("#username").html("<div class=\"User\"><h3>用户:" + username + "</h3></div><div class=\"UState\" style=\"color: orangered \"><h3>离线</h3></div>");

        }
        //心跳连接代码,处于连接状态，发送信息，非连接状态 重制信息
        var heartCheck = {
            timeout: 55000,        // 一段时间（55秒）进行一次心跳，比server端设置的连接时间稍微小一点，在接近断开的情况下以通信的方式去重置连接时间。
            serverTimeoutObj: null,
            reset: function () {
                clearTimeout(this.timeoutObj);
                clearTimeout(this.serverTimeoutObj);
                return this;
            },
            start: function () {
                var self = this;
                this.serverTimeoutObj = setInterval(function () {
                    if (ws.readyState == 1) {
                        console.log("连接状态，发送消息保持连接");
                        ws.send("ping");
                        heartCheck.reset().start();    // 如果获取到消息，说明连接是正常的，重置心跳检测
                    } else {
                        console.log("断开状态，尝试重连");
                        newWebSocket();
                    }
                }, this.timeout)
            }
        }
        //发送消息
        $("#submit").click(function () {
            //0.说话次数加一
            Count += 1;
            //1.1获取输入的内容
            var atwhos = [];
            var input = document.getElementById("input_text");
            var data = input.innerHTML;
            //获取at数据
            var ats = $("span[class='atwho-inserted']");
            //将at数据存入数组
            console.log(ats.length);
            for (var i = 0; i < ats.length; i++) {
                atwhos.push(ats[i].innerHTML.replace("@", ""));
            }
            console.log(atwhos);
            //2.清空发送框
            input.innerHTML = "";
            document.getElementById("editable").innerHTML = "";
            if (Group == false) {
                console.log("发送消息给个人")
                var json = {"toName": toName, "message": data, "group": false};
                //将数据展示在聊天区
                var str = "<div class=\"bubble-right\"><span>" + data + "</span></div></br></br></br>";
                $("#content").append(str);
                //将聊天记录存储到局部寄存器

                var chatData = sessionStorage.getItem(toName);
                if (chatData != null) {
                    str = chatData + str;
                }
                sessionStorage.setItem(toName, str);
            } else {
                console.log("消息发送给小组");
                var json = {
                    "toName": UserGroup,
                    "message": data,
                    "group": true,
                    "atwhos": atwhos,
                    "at": atwhos.length != 0,
                    "sender": username
                };
                //将数据展示在聊天区
                console.log(json);
                var at = "";
                for (var i = 0; i < atwhos.length; i++) {
                    at += "<div style='color:lightskyblue;display: inline'>@" + atwhos[i] + "</div>";
                }
                var str = "<div class=\"bubble-right\"><span>" + at + data + "</span></div></br></br></br>";
                $("#content").append(str);
                //将聊天记录存储到局部寄存器

                var chatData = sessionStorage.getItem(UserGroup);
                if (chatData != null) {
                    str = chatData + str;
                }
                sessionStorage.setItem(UserGroup, str);
                isMe = true;
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
    L2Dwidget.init({
        "model": {
            jsonPath:
                "https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json",
            "scale": 1
        }, "display": {
            "position": "right", "width": 210, "height": 250,
            "hOffset": 0, "vOffset": -20
        }, "mobile": {"show": true, "scale": 0.5},
        "react": {"opacityDefault": 0.8, "opacityOnHover": 0.1}
    });
</script>
<%--表情包导入--%>
<script src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.6.8/vue.min.js'></script>
<script src="static/script/chat-script.js"></script>
<%--静态资源直接导入--%>
<script src="static/script/jqueryAtwho.js"></script>
<%--模版动态样式导入--%>
<%--<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script  src="static/script/chat_remainder.js"></script>--%>
</html>
