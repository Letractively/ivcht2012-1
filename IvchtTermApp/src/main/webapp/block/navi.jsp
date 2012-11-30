<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<table class="example">
    <tr>
        <th>Марка</th>
        <th>Модель</th>
        <th>Число мест</th>
        <th>Габариты</th>
        <th>Описание</th>
    </tr>
    <c:forEach items="${autos}" var="auto">
    </c:forEach>
</table>