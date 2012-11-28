<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
</head>
<body>

        <h2>Автомобили</h2>
        <table class="example">
            <tr>
                <th>Марка</th>
                <th>Модель</th>
                <th>Число мест</th>
                <th>Габариты</th>
                <th>Описание</th>
             </tr>
            <c:forEach items="${autos}" var="auto">
                <tr>
                    <td><c:out value="${auto.brand}"></c:out></td>
                    <td><c:out value="${auto.model}"></c:out></td>
                    <td><c:out value="${auto.seat}"></c:out></td>
                    <td><c:out value="${auto.len}"></c:out>x<c:out value="${auto.width}"></c:out>x<c:out value="${auto.height}"></c:out></td>
                    <td><c:out value="${auto.descr}"></c:out></td>
                </tr>
            </c:forEach>
        </table>

        <div class="block">
            <div id="head"><jsp:include page="block/head.jsp"></jsp:include></div>
            <div id="navi"><jsp:include page="block/navi.jsp"></jsp:include></div>
            <div id="left" class="links"><jsp:include page="block/left.jsp"></jsp:include></div>
            <div id="cont"><p>
                <%--  <table class="bordered">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Top 10 Jeeps</th>
                        <th>?</th>
                    </tr>
                    </thead>
                    <tr>
                        <td>1</td>
                        <td>Land C</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Gran Sh</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>8</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>9</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>10</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>--%>
                <div id="foot"><jsp:include page="block/foot.jsp"></jsp:include></div>


    </p>

        <p id="inp"><form action="">
        <input type="text"></input>
    </form>
        </p>
        <hr class="full">
        <h6>
            <a href="createdatabase">Создать базу данных</a>    <br>
            <a href="https://code.google.com/p/ivcht2012-1">Страница проекта</a>   <br>
            <a href="listbrand">Список марок авто</a>
            <a href="listauto">Список авто</a>
        </h6>
    </div>





</body>
</html>