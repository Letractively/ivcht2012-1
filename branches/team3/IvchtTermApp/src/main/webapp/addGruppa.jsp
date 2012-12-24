<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<html>
<head>
    <title>Student List</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <style type="text/css">
        table.example {
            background-color: #b9b9b9;
            width: 600px;
        }

        .example tr {
            background-color: #ffeeee;
            height: 30px
        }
        span.error {
            color: red;
        }
    </style>

</head>
<body>
<h2>Добавление новой студента</h2>

<form action="addGruppa" method="post">
    <table class="example">
        <tr>
            <td>Фамилия</td>
            <td><input type="text" name="namegrupp"/></td>
        </tr>
        <tr>
            <td>Имя</td>
            <td><input type="text" name="info" /></td>
        </tr>
                <tr>
            <td></td>
            <td>
                <input type="submit" value="Добавить"/>
                <input type="reset" value="Очистить"/>
            </td>
        </tr>
    </table>
</form>

<c:if test="${not empty result}">
    <span> <c:out value="${result}"></c:out></span>
</c:if>

<c:if test="${not empty error}">
    <span class="error"><c:out value="${error}"></c:out></span>
</c:if>

<br/>
<br/>

<a href="genreList?i=2">К списку студентов</a><br/>
<a href="index.jsp">На главную</a><br/>
</body>
</html>