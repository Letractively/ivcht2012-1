<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    <html>
    <body>

    <c:forEach items="${autos}" var="brand">
        <a href="listauto?id=<c:out value="${brand.id}"></c:out>"><c:out value="${brand.brand}"></c:out></a>    <br>
    </c:forEach>

    </body>
    </html>