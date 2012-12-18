<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.11.12
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>

    <title>N/A</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <!-- Styles
    <link rel=stylesheet href="resources/css/base.css" type="text/css">

    <style type="text/css">

    </style>
    -->
</head>

<body>
topic list
<!-- TODO: result получение переменной из сервлета -->

<h2>Список тем</h2>
<table class="example">
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Дата создания</th>
        <th>Изменение</th>
        <th>Удаление</th>
    </tr>
    <c:forEach items="${topics}" var="topic">
        <tr>
            <td><c:out value="${topic.id}"></c:out></td>
            <td><c:out value="${topic.subject}"></c:out></td>
            <td><c:out value="${topic.description}"></c:out></td>
            <td><c:out value="${topic.formattedDate}"></c:out></td>
            <td><a href="editStudent?id=<c:out value="${student.id}"></c:out>">Изменить</a></td>
            <td><a href="delStudent?id=<c:out value="${student.id}"></c:out>">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>