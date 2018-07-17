<%--
  Created by IntelliJ IDEA.
  User: szhiy
  Date: 18.7.17
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Day05_1</title>
</head>
<body>
<hr>
<%--调用的是 set 方法赋值的！！！ 不是构造器，但是需要一个空参构造器--%>
<form action="${pageContext.request.contextPath}/addUser.do">
    学号：<input type="text" name="id">
    姓名：<input type="text" name="name">
    年龄：<input type="text" name="age">
    住址：<input type="text" name="home">
    <input type="submit" value="提交">
</form>
<hr>
</body>
</html>
