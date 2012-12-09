<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<table class="bordered">
    <tr>
        <th>Двигатель</th>
        <th>Трансмиссия</th>
        <th>Привод</th>
        <th>Цена</th>
        <th>Рейтинг</th>
        <th>Дата начала продаж</th>
        <th>Наличие</th>

    </tr>
    <c:forEach items="${packag}" var="packag">
        <tr>
            <td><c:out value="${packag.motor}"></c:out></td>
            <td><c:out value="${packag.transmission}"></c:out></td>
            <td><c:out value="${packag.drive}"></c:out></td>
            <td><c:out value="${packag.price}"></c:out></td>
            <td><c:out value="${packag.rating}"></c:out></td>
            <td><c:out value="${packag.datestart}"></c:out></td>
            <td><c:out value="${packag.checked}"></c:out></td>
        </tr>
    </c:forEach>
</table>