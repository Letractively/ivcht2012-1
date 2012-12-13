<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:if test="${empty packag}">
    <jsp:forward page="/listpackage"/>
</c:if>

<html>
<body>
<table class="bordered">
    <tr>
        <th>Двигатель</th>
        <th>Трансмиссия</th>
        <th>Привод</th>
        <th>Цена</th>
        <th>Наличие</th>

    </tr>
    <c:forEach items="${packag}" var="packag">
        <tr>
            <td><c:out value="${packag.motor}"></c:out></td>
            <td><c:out value="${packag.transmission}"></c:out></td>
            <td><c:out value="${packag.drive}"></c:out></td>
            <td><c:out value="${packag.price}"></c:out></td>
            <td><c:out value="${packag.checked}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>