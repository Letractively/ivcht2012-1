<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
    <link rel=stylesheet href="resources/themes/theme<c:out value="${sessionScope.theme}"/>/theme.css" type="text/css">
</head>

<body>
<h1>Welcome to study IVCHT project</h1>

<div>
    <img src="resources/img/welcome.gif">
</div>

<hr class="full">

<div>
    <span>
        Это учебный проект выполняемый группой мИВЧТ-11 2012/2013 обучения
    </span>
</div>

<br/>
<hr class="full">

<a href="welcome">На страницу приветствия</a><br/>
<a href="chooseTheme.jsp">Выбрать тему</a>

</body>
</html>
