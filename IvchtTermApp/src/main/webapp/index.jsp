<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
</head>
<body>
<div class="block">
    <div id="head"><jsp:include page="block/head.jsp"></jsp:include></div>
    <div id="navi"><jsp:include page="block/navi.jsp"></jsp:include></div>
    <div id="left" class="links"><jsp:include page="block/left.jsp"></jsp:include></div>
    <div id="cont"><p>
        <table class="bordered">
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
        </table>
        </p>

        <p id="inp"><form action="">
        <input type="text"></input>
    </form>
        </p>
        <hr class="full">
        <h6>
            <a href="createdatabase">Создать базу данных</a>    <br>
            <a href="https://code.google.com/p/ivcht2012-1">Страница проекта</a>
        </h6>
    </div>



    <div id="foot"><jsp:include page="block/foot.jsp"></jsp:include></div>
</div>
</body>
</html>