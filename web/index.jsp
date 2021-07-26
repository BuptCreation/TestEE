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
<%@ page import="com.alibaba"   %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$helllo what can i do
  </body>
</html>
