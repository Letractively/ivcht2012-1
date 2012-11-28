<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    <html>
    <body>

    <c:forEach items="${autos}" var="auto">
        <a href="listauto?id=<c:out value="${auto.id}"></c:out>"><c:out value="${auto.brand}"></c:out></a>    <br>
    </c:forEach>

    </body>
    </html>