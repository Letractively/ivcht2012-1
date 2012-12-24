<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.11.12
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>

    <title>Сообщения</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
</head>

<body>

<!-- TODO: result получение переменной из сервлета -->

<h2>Список сообщений в теме</h2>


<a href="messageAdd.jsp">Добавить сообщение</a>

<table class="example" border="1">
    <tr>
        <th>ID</th>
        <th>Содержимое</th>
        <th>Дата сообщения</th>
        <th>Удалить</th>
    </tr>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td><c:out value="${message.id}"></c:out></td>
            <td><c:out value="${message.contents}"></c:out></td>
            <td><c:out value="${message.formattedDate}"></c:out></td>
            <td><a href="messageDelete?id=<c:out value="${message.id}"></c:out>"><img src="resources/img/Delete.png"></a></td>
        </tr>
    </c:forEach>
</table>
Количество сообщений в теме: <c:out value="${count}"></c:out>
<br/>
<a href="topicList">К списку тем</a>
<br/>
<a href="index.jsp">На главную страницу</a>
</body>
</html>