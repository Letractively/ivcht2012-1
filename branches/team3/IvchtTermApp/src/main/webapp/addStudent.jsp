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

<form action="addStudent" method="post">
    <table class="example">
        <tr>
            <td>Фамилия</td>
            <td><input type="text" name="secondName"/></td>
        </tr>
        <tr>
            <td>Имя</td>
            <td><input type="text" name="firstName" /></td>
        </tr>
        <tr>
            <td>Дата рождения(01.01.1999)</td>
            <td><input type="text" name="birthday" /></td>
        </tr>
        <tr>
            <td>Рост</td>
            <td><input type="text" name="height" /></td>
        </tr>
        <tr>
            <td>Группа</td>
            <td>

                <select name="grId">
                    <option disabled>Выберите группу</option>
                    <c:forEach items="${grupps}" var="gruppa">
                         <option value="<c:out value='${gruppa.id}'></c:out>"><c:out value="${gruppa.namegrupp}"></c:out></option>
                     </c:forEach>
                </select>

            </td>

        </tr>
        <tr>
            <td>
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

<a href="studentList">К списку студентов</a><br/>
<a href="index.jsp">На главную</a><br/>
</body>
</html>