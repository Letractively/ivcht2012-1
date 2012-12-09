<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
</head>
<title>Автомобили</title>
<body>
<div class="block">
            <div id="head"><jsp:include page="block/head.jsp"></jsp:include></div>
            <div id="navi" class="nav"><jsp:include page="block/navi.jsp"></jsp:include></div>
            <div id="left" class="links"><jsp:include page="block/left.jsp"></jsp:include></div>
            <div id="cont">

                <c:if test="${empty autos}">
                    <jsp:forward page="/listauto"/>
                </c:if>

                <table class="bordered">
                    <tr>
                        <th>Марка</th>
                        <th>Модель</th>
                        <th>Число мест</th>
                        <th>Габариты</th>
                        <th>Описание</th>
                        <th>Рейтинг</th>
                        <th>Цена</th>


                    </tr>
                    <c:forEach items="${autos}" var="auto">
                        <tr>
                            <td><c:out value="${auto.brand}"></c:out></td>
                            <td><a href="listpackage?tps=<c:out value="${auto.id}"></c:out>"><c:out value="${auto.model}"></c:out></a></td>
                            <td><c:out value="${auto.seat}"></c:out></td>
                            <td><c:out value="${auto.len}"></c:out>x<c:out value="${auto.width}"></c:out>x<c:out value="${auto.height}"></c:out></td>
                            <td><c:out value="${auto.descr}"></c:out></td>
                            <td><c:out value="${auto.rating}"></c:out></td>
                            <td><c:out value="${auto.price}"></c:out></td>
                        </tr>
                    </c:forEach>
                </table>


            </div>
            <div id="foot"><jsp:include page="block/foot.jsp"></jsp:include>
                <p id="inp"><form action="">
                    <input type="text"></input>
                </form>
                </p>
                <hr class="full">
                <h6>
                    <a href="createdatabase">Создать базу данных</a>    <br>
                    <a href="https://code.google.com/p/ivcht2012-1">Страница проекта</a>   <br>
                    <a href="listbrand">Список марок авто</a> <br>
                    <a href="listauto">Список авто</a> <br>
                    <a href="listtypes">Список кузовов</a> <br>
                    <a href="listpackage">Модели</a> <br>
                    <a href="index.jsp">Вернуться на главную</a>
                </h6>
            </div>


</div>
</body>
</html>