<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<img style="float: left;" src="resources/img/auto.jpg" width="250px" height="200px" /> <h1>Автомобили</h1>
<c:if test="${empty types}">
    <jsp:forward page="/listtypes"/>
</c:if>
<c:forEach items="${types}" var="types">
    <a href="listpackage?tps=<c:out value="${types.id}"></c:out>"><c:out value="${types.types}"></c:out></a>    <br>
</c:forEach>