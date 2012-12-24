<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<c:if test="${empty types}">
    <jsp:forward page="/listtypes"/>
</c:if>
<c:forEach items="${types}" var="types">
    <a href="listauto?tps=<c:out value="${types.id}"></c:out>"><c:out value="${types.types}"></c:out></a>
</c:forEach>
