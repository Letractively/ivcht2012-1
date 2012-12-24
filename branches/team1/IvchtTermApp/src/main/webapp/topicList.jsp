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
<a href="topicAdd.jsp">Добавить тему</a>
<table class="example" border="1">
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
            <td><a href="messageList?id=<c:out value="${topic.id}"></c:out>"><c:out value="${topic.subject}"></c:out></a></td>
            <td><c:out value="${topic.description}"></c:out></td>
            <td><c:out value="${topic.formattedDate}"></c:out></td>
            <td><a href="topicEdit?id=<c:out value="${topic.id}"></c:out>">Изменить</a></td>
            <td><a href="topicDelete?id=<c:out value="${topic.id}"></c:out>">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
Количество тем на форуме: <c:out value="${count}"></c:out>
<br/>
<%-- Обработка результата запроса - result --%>

<c:if test="${not empty result}">
    <span> <c:out value="${result}"></c:out></span>
    <br/>
</c:if>

<%-- Обработка ошибок запроса - error --%>

<c:if test="${not empty error}">
    <span class="error"><c:out value="${error}"></c:out></span>
    <br/>
</c:if>
<br/>
<a href="index.jsp">На главную страницу</a>
</body>
</html>