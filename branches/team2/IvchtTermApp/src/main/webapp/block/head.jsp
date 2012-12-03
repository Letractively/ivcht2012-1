<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<img style="float: left;" src="resources/img/auto.jpg" width="250px" height="200px" /> <h1>Автомобили</h1>
<html>
<body>

<c:forEach items="${autos}" var="types">
    <a href="listauto?tps=<c:out value="${types.id}"></c:out>"><c:out value="${types.types}"></c:out></a>    <br>
</c:forEach>

</body>
</html>