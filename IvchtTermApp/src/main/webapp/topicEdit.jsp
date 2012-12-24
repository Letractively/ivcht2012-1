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

    <title>N/A</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <!-- Styles
    <link rel=stylesheet href="resources/css/base.css" type="text/css">

    <style type="text/css">

    </style>
    -->
</head>

<body>
topic edit

<h2>Изменение темы</h2>

<%-- Форма отправки запроса добавления темы --%>
<form action="topicEditApply" method="post">
    <table class="edit">
        <tr>
            <td>Идентификатор темы</td>
            <td><input type="text" name="id" style="background:#b9b9b9" readonly="readonly" value="<c:out value="${topic.id}"></c:out>" /></td>
        </tr>
        <tr>
            <td>Название темы</td>
            <td><input type="text" name="subject" size="50" value="<c:out value="${topic.subject}"></c:out>" /></td>
        </tr>
        <tr>
            <td>Описание</td>
            <td><input type="text" name="description" size="100" value="<c:out value="${topic.description}"></c:out>" /></td>
        </tr>
        <tr>
            <td>Дата создания темы</td>
            <td><input type="text" name="createDate" style="background:#b9b9b9" readonly="readonly" value="<c:out value="${topic.formattedDate}"></c:out>" /></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Изменить"/>
            </td>
        </tr>
    </table>
</form>

<%-- Обработка результата запроса - result --%>

<c:if test="${not empty result}">
    <span> <c:out value="${result}"></c:out></span>
</c:if>

<%-- Обработка ошибок запроса - error --%>

<c:if test="${not empty error}">
    <span class="error"><c:out value="${error}"></c:out></span>
</c:if>

<br/>
<br/>

<a href="topicList">К списку тем</a><br/>
<a href="index.jsp">На главную страницу</a><br/>
</body>
</html>