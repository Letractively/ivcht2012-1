<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<html>
<head>
    <title>Genre List</title>

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
    <h2>Список групп</h2>
    <table class="example">
        <tr>
            <th>Код</th>
            <th>Название</th>
            <th>Описание</th>

            <th>Удаление</th>
            <th>Редактирование</th>
            <th>Список студентов</th>
        </tr>
        <c:forEach items="${grupps}" var="genre">
            <tr>
                <td><c:out value="${gruppa.id}"></c:out></td>
                <td><c:out value="${gruppa.namegrupp}"></c:out></td>
                <td><c:out value="${gruppa.info}"></c:out></td>

                <td><a href="DeleteGrupp?id=<c:out value='${gruppa.id}'></c:out>">удалить</a></td>
                <td><a href="showGrupp?id=<c:out value='${gruppa.id}'></c:out>">редактировать</a></td>
                <td><a href="studentGrList?id=<c:out value='${gruppa.id}'></c:out>">список студентов</a></td>
            </tr>
        </c:forEach>
    </table>


    <a href="addGruppa.jsp">Добавить</a><br/>
    <a href="index.jsp">На главную</a><br/>
</body>
</html>