<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            background-color: #eeffee;
            height: 30px
        }

    </style>

</head>
<body>
    <h2>Список студентов</h2>
    <table class="example">
        <tr>
            <th>Код</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Дата рождения</th>
            <th>Рост</th>
            <th>Группа</th>
            <th>Удаление</th>
            <th>Редактирование</th>
        </tr>
        <c:forEach items="${students}" var="film">
            <tr>
                <td><c:out value="${student.id}"></c:out></td>
                <td><c:out value="${student.secondName}"></c:out></td>
                <td><c:out value="${student.firstName}"></c:out></td>
                <td><c:out value="${student.fbirthday}"></c:out></td>
                <td><c:out value="${student.height}"></c:out></td>
                <td><c:out value="${groupMap[student.grId]}"/><br/></td>
                <td><a href="DeleteStudent?id=<c:out value='${student.id}'></c:out>">удалить</a></td>
                <td><a href="showStudent?id=<c:out value='${student.id}'></c:out>">редактировать</a></td>
            </tr>
        </c:forEach>
    </table>
    <c:out value="${count}"/>
  <a href="genreList?i=1">Добавить</a><br/>
    <a href="index.jsp">На главную</a><br/>
    <a href="genreList?i=2">Список групп</a><br/>
</body>
</html>