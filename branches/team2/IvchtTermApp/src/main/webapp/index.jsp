<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
</head>
<title>Автомобили</title>
<body>

<%--<jsp:forward page="/createdatabase"/> -%>// Создание БД     --%>
<div class="block">
            <div id="head"><jsp:include page="block/head.jsp"></jsp:include></div>
            <div id="navi" class="nav"><jsp:include page="block/navi.jsp"></jsp:include></div>
            <div id="left" class="links"><jsp:include page="block/left.jsp"></jsp:include></div>
            <div id="cont">



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
                            <form>
                            <td><c:out value="${auto.brand}"></c:out></td>
                            <td><a href="listpackage?tps=<c:out value="${auto.id}"></c:out>"><c:out value="${auto.model}"></c:out></a></td>
                            <td><c:out value="${auto.seat}"></c:out></td>
                            <td><c:out value="${auto.len}"></c:out>x<c:out value="${auto.width}"></c:out>x<c:out value="${auto.height}"></c:out></td>
                            <td><c:out value="${auto.descr}"></c:out></td>
                            <td><c:out value="${auto.rating}"></c:out></td>
                            <td><c:out value="${auto.price}"></c:out></td>
                                <td><a href="readauto?id=<c:out value="${auto.id}"></c:out>">Редактировать</a></td>
                                <td><a href="deleteauto?id=<c:out value="${auto.id}"></c:out>" onclick="confirm('Вы подтверждаете удаление?')">Удалить</a></td>
                             </form>
                        </tr>
                    </c:forEach>
                </table>


            </div>
            <div id="foot"><jsp:include page="block/foot.jsp"></jsp:include>
                </p>
                <hr class="full">
                <h4>
                    <a href="createdatabase">Создать базу данных</a>    <br>
                    <a href="https://code.google.com/p/ivcht2012-1">Страница проекта</a>   <br>
                    <a href="listbrand">Список марок авто</a> <br>
                    <a href="listauto">Список авто</a> <br>
                    <a href="listtypes">Список кузовов</a> <br>
                    <a href="listpackage">Модели</a> <br>
                    <a href="index.jsp">Вернуться на главную</a> <br>
                    <a href="addpackage">Добавление модели</a> <br>
                    <a href="addauto">Добавление авто</a> <br>
                 </h4>
                <c:if test="${not empty result_editauto}">
                    <script type="text/javascript">alert("Изменения модели зафиксированы")</script>

                </c:if>
                <c:if test="${not empty result_addauto}">
                    <script type="text/javascript">alert("Внесена новая модель авто")</script>
                </c:if>
                <c:if test="${not empty result_deleteauto}">
                    <script type="text/javascript">alert("Авто удалено")</script>
                </c:if>
                <c:if test="${not empty error_deleteauto}">
                    <script type="text/javascript">alert("Ошибка при удалении авто")</script>
                </c:if>


            </div>
</div>
</body>
</html>