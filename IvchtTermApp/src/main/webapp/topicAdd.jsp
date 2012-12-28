<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28.11.12
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>

    <title>Добавление темы</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>


    <link rel=stylesheet href="resources/css/base.css" type="text/css">

</head>

<body>
<h2>Новая тема</h2>

<%-- Форма отправки запроса добавления темы --%>
<form action="topicAdd" method="post">
    <table class="add">
        <tr>
            <td>Название темы</td>
            <td><input type="text" name="subject" size="50"/></td>
        </tr>
        <tr>
            <td>Описание</td>
            <td><input type="text" name="description" size="100"/></td>
        </tr>
        <tr>
            <td></td>
            <td>

                <input type="submit" value="Добавить" onclick="this.disabled=true; this.form.submit(); return false;" />
                <input type="reset" value="Очистить"/>
            </td>
        </tr>
    </table>
</form>

<%-- Обработка результата запроса - result --%>

<c:if test="${not empty result}">
    <span> <c:out value="${result}"></c:out></span>
    <script>

        setTimeout('location = "topicList"', 2000) </script>
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