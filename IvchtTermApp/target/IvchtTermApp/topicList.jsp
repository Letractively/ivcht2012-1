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

    <title>Список тем</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">



</head>

<body>
<h2>Список тем</h2>
<a href="topicAdd.jsp"><img src="resources/img/button_topic.png" border="2"></a>
<br>
<table class="example" border="1">
    <tr>
        <th>Название</th>
        <th>Дата создания</th>
        <th></th>
    </tr>
    <c:forEach items="${topics}" var="topic">
        <tr>
            <td width="500">
                <b><a href="messageList?topicID=<c:out value="${topic.id}"></c:out>"><c:out value="${topic.subject}"></c:out></a></b>
                <font size="1">(Тема создана: <c:out value="${topic.formattedDate}"></c:out>)</font>
                <br>
                <c:out value="${topic.description}"></c:out>
            </td>
            <td><c:out value="${topic.formattedDate}"></c:out></td>
            <td><a href="topicEdit?id=<c:out value="${topic.id}"></c:out>">
                <img src="resources/img/edit.png" >
            </a>

                <a href="topicDelete?id=<c:out value="${topic.id}"></c:out>">
                    <img src="resources/img/Delete.png">
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
Количество тем на форуме: <c:out value="${count}"></c:out>
<br/>

<br/>

<%-- Форма отправки запроса поиска темы --%>
<form action="topicSearch" method="post">
    <table class="search">
        <tr>
            <td>Поиск темы</td>
            <td></td>
        </tr>
        <tr>
            <td>
                <input type="text" name="searchString" size="50"/>
            </td>
            <td>
                <input type="submit" value="Поиск"/>
            </td>
        </tr>
    </table>
</form>

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