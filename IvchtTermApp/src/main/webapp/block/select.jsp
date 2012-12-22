<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 18.12.12
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<div>
<h1 align="center">Подбор авто по параметрам</h1>
<form action="selectauto" accept="" method="post">
    <c:if test="${not empty error}">
        <script type="text/javascript">alert("Нет машин по заданным параметрам, попробуйте еще раз...")</script>
    </c:if>
    <table class="bordered">
    <tr>
        <td>Производитель</td>
        <td>
            <select name="id" id="Select1" size="1" required>
                <c:if test="${not empty brand}">
                    <c:forEach items="${brand}" var="brand">
                        <option value="<c:out value="${brand.id}"></c:out>"><c:out value="${brand.brand}"></c:out></option>
                    </c:forEach>
            </select>
            </c:if></td>
    </tr>
    <br>
    <tr>
        <td>Кузов</td>
        <td> <select name="tps" id="Select2" size="1" required>
            <c:if test="${not empty types}">
                <c:forEach items="${types}" var="types">
                    <option value="<c:out value="${types.id}"></c:out>"><c:out value="${types.types}"></c:out></option>
                </c:forEach>
            </c:if></select></td>
    </tr>
    <tr><td><input type="submit" value="Search"></td><td>&nbsp</td></tr>
    </table>
 </form>
</div>