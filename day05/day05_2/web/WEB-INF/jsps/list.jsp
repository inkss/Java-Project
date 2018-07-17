<%--
  Created by IntelliJ IDEA.
  User: szhiy
  Date: 18.7.16
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%--引入 jstl 标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>列表首页</title>
</head>
<body>

<br>

<table border="2px" width="500">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${userList}" var="user">

    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>
            <%--<c:if test="${user.sex ==1}">男</c:if>
            <c:if test="${user.sex ==0}">女</c:if>--%>

            <c:choose>
                <c:when test="${user.sex ==1}">男</c:when>
                <c:otherwise>女</c:otherwise>
            </c:choose>
        </td>
        <td>${user.age}</td>
        <td>
            <a href="${pageContext.request.contextPath}/list/delete/${user.id}.do">删除</a>
            <a href="${pageContext.request.contextPath}/list/toUpdate.do?id=${user.id}">修改</a>
        </td>
    </tr>

    </c:forEach>
</table>

</body>
</html>