<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<ul>
    <c:forEach items="${autos}" var="auto">
    <li><a><c:out value="${auto.brand}"></c:out></a></li>
    </c:forEach>
</ul>