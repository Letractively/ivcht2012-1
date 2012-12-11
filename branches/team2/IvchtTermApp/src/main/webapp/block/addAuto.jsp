<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 11.12.12
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="addauto" accept="" method="post">
    <table class="example">
        <tr>
            <td>Производитель</td>
            <td>
                <select name="id_brand" id="Select1" size="1" required>
                    <c:if test="${not empty brand}">
                <c:forEach items="${brand}" var="brand">
                    <option value="<c:out value="${brand.id}"></c:out>"><c:out value="${brand.brand}"></c:out></option>
                </c:forEach>
                    </select>
            </c:if></td>
        </tr>
        <tr>
            <td>Марка</td>
            <td><input type="text" name="model"/></td>
        </tr>
        <tr>
            <td>Кузов</td>
            <td> <select name="id_types" id="Select2" size="1" required>
                <c:if test="${not empty types}">
                <c:forEach items="${types}" var="types">
                    <option value="<c:out value="${types.id}"></c:out>"><c:out value="${types.types}"></c:out></option>
            </c:forEach>
                </c:if>  </select></td>
        </tr>
        <tr>
            <td>Число мест</td>
            <td><input type="text" name="seat"/></td>
        </tr>
        <tr>
            <td>Габариты(ВхШхД),мм</td>
            <td><input type="text" name="height"/>x<input type="text" name="width"/>x<input type="text" name="len"/></td>
        </tr>
        <tr>
            <td>Рейтинг</td>
            <td><select name="rating" id="Sel" size="1" required>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
               <option>10</option>
             </select></td>
        </tr>
        <tr>
            <td>Цена, от</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>Описание</td>
            <td><input type="textarea" name="descr" rows="3"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Добавить"/>
                <input type="reset" value="Очистить"/>
            </td>
        </tr>
             </table>
</form>

<c:if test="${not empty result}">
    <span> <c:out value="${result}"></c:out></span>
</c:if>

<c:if test="${not empty error}">
    <span class="error"><c:out value="${error}"></c:out></span>
</c:if>
</body>
</html>