<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.12.12
  Time: 9:05
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
<form action="addpackage" method="post">
    <table class="example">
        <%--<tr>--%>
        <%--<td>Код</td>--%>
        <%--<td><input type="text" name="id"/></td>--%>
        <%--</tr>--%>
            <tr>
                <td>Марка авто</td>
                <td><select name="id_auto" id="Select1" size="1" required>
                    <c:if test="${not empty autos}">
                    <c:forEach items="${autos}" var="auto">
                        <option value="<c:out value="${auto.id}"></c:out>"><c:out value="${auto.brand}"></c:out>   <c:out value="${auto.model}"></c:out>    <c:out value="${auto.types}"></c:out></option>
                     </c:forEach>
                     </c:if>
                </select></td>
            </tr>
        <tr>
            <td>Двигатель, см</td>
            <td><input type="text" name="motor"/></td>
        </tr>
        <tr>
            <td>Трансмиссия</td>

            <td><select name="transmission" id="Select2" size="1" required>
                <option>AT</option>
                <option>MT</option>
            </select></td>
        </tr>
            <tr>
                <td>Привод</td>
                <td><select name="drive" id="Select3" size="1" required>
                    <option>Передний</option>
                    <option>Задний</option>
                    <option>Полный</option>
                </select></td>
            </tr>
            <tr>
                <td>Цена комплектации</td>
                 <td><input type="text" name="price"/></td>
            </tr>
        <tr>
            <td>Наличие</td>
            <td><input type="checkbox" name="checked" checked="checked"/></td>
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



<br/>
<br/>
<c:if test="${not empty error}">
    <script type="text/javascript">alert("Ошибка в данных, попробуйте еще раз...")</script>
</c:if>
</body>
</html>