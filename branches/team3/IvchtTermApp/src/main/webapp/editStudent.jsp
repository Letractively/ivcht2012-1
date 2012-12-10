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
<h2>Добавление нового студента</h2>

<form action="editStudent" method="post">
    <table class="example">
        <%--<tr>--%>
            <%--<td>Код</td>--%>
            <%--<td><input type="text" name="id"/></td>--%>
        <%--</tr>--%>
        <tr>
            <td>Фамилия</td>
            <td><input type="text" name="secondName" value="<c:out value='${student.secondName}'></c:out>"/>
                <input type="hidden"  name="id" value="<c:out value='${student.id}'></c:out>"/>
            </td>
        </tr>
        <tr>
            <td>Имя</td>
            <td><input type="text" name="firstName" value="<c:out value='${student.firstName}'></c:out>"/></td>
        </tr>
        <tr>
            <td>Дата рождения(01.01.1999)</td>
            <td><input type="text" name="birthday" value="<c:out value='${student.fbirthday}'></c:out>"/></td>
        </tr>
        <tr>
            <td>Рост</td>
            <td><input type="text" name="height" value="<c:out value='${student.height}'></c:out>"/></td>
        </tr>
            <tr>
                <td>группа</td>
                <td><input type="text" name="grId" value="<c:out value='${student.grIdt}'></c:out>"/></td>
            </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Обновить"/>
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

<a href="filmList">К списку студентов</a><br/>
<a href="index.jsp">На главную</a><br/>
</body>
</html>