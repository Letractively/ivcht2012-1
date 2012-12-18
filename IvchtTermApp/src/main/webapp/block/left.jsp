<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<ul>
<c:if test="${empty brand}">
    <jsp:forward page="/listbrand"/>
</c:if>
    <li><c:forEach items="${brand}" var="brand">
    <a href="listauto?id=<c:out value="${brand.id}"></c:out>"><c:out value="${brand.brand}"></c:out></a>    <br>
</c:forEach>   </li>
    <br>
    <br>
    <br>
    <a href="pageselect.jsp">Подбор по параметрам</a>
    <br>
    <br>
    <a href="addauto">Добавить автомобиль</a>
    <br>
    <br>
    <a href="addpackage">Добавить комплектацию</a>
</ul>

