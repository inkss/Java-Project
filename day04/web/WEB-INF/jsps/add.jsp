<%--
  Created by IntelliJ IDEA.
  User: szhiy
  Date: 18.7.16
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<h2>你访问的是添加页面</h2>

<form action="${pageContext.request.contextPath}/addUserID.do">
    学号：
    <input type="text" name="id">

    <input type="submit" value="提交">

</form>
<hr>
<form action="${pageContext.request.contextPath}/addUser.do">
    学号：<input type="text" name="id">
    姓名：<input type="text" name="name">
    年龄：<input type="text" name="age">
    性别：<input type="text" name="sex">
    <input type="submit" value="提交">
</form>
<hr>

<%--提交集合--%>
<form action="${pageContext.request.contextPath}/addUserList.do">
    学号1：<input type="text" name="userList[0].id">
    姓名1：<input type="text" name="userList[0].name">

    学号2：<input type="text" name="userList[1].id">
    姓名2：<input type="text" name="userList[1].name">
    <input type="submit" value="提交">
</form>
</body>
</html>
