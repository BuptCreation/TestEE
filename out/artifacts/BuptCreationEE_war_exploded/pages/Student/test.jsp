<%--
  Created by IntelliJ IDEA.
  User: tigers
  Date: 2021/8/17
  Time: 12:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta http-equiv="x-ua-compatible"  content="IE=Edge" charset="utf-8"/>
    <title>At.js</title>
    <!--    基础路径-->
    <base href="../../">
    <link rel="stylesheet" href="static/css/jqueryAtwho.css" />
    <link rel="stylesheet" href="static/css/atwho.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://ichord.github.io/Caret.js/src/jquery.caret.js"></script>
    <script   src="static/script/jqueryAtwho.js"></script>
    <script type="text/javascript">
        $(function(){

            var jeremy = decodeURI("J%C3%A9r%C3%A9my");
            var tags = ["前端样式 完毕","该列表需要自动维护","张景鸿","张景","景鸿"];
            $('#editable').atwho({
                at: "@",
                data: tags,
                limit: 200,
                callbacks: {
                    afterMatchFailed: function(at, el) {
                        // 32 is spacebar
                        if (at == '@') {
                            tags.push(el.text().trim().slice(1));
                            this.model.save(tags);
                            this.insert(el.text().trim());
                            return false;
                        }
                    }
                }
            });
        });
    </script>
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
<body>
<div class="container wrapper">
    <header>
        <h3>Type `#` to autocomplete tags</h3>
    </header>
    <div id="main">
        <div id="editable" class="inputor" contentEditable="true">你好</div>
    </div>
</div>
</body>
</html>
