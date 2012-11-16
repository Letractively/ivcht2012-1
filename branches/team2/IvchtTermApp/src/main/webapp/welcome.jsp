<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
</head>
<body>
    <h2>Страница приветствия</h2>
    <span class="info">
        <c:out value="${welcomeMessage}"></c:out>
    </span>
    <br/>
    <hr class="full">
    <a href="index.jsp">Вернуться на главную</a>
</body>
</html>