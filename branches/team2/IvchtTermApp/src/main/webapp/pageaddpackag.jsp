<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
</head>
<title>Автомобили1</title>
<body>
<div class="block">
    <div id="head"><jsp:include page="block/head.jsp"></jsp:include></div>
    <div id="navi" class="nav"><jsp:include page="block/navi.jsp"></jsp:include></div>
    <div id="left" class="links"><jsp:include page="block/left.jsp"></jsp:include></div>
    <div id="cont"><jsp:include page="block/addPackag.jsp"></jsp:include> </div>
    <div id="foot"><jsp:include page="block/foot.jsp"></jsp:include>
        <hr class="full">
        <h6>
            <a href="createdatabase">Создать базу данных</a>    <br>
            <a href="https://code.google.com/p/ivcht2012-1">Страница проекта</a>   <br>
            <a href="listbrand">Список марок авто</a> <br>
            <a href="listauto">Список авто</a> <br>
            <a href="listtypes">Список кузовов</a> <br>
            <a href="listpackage?page=1">Модели</a> <br>
            <a href="index.jsp">Вернуться на главную</a>
        </h6>
    </div>
</div>
</body>
</html>