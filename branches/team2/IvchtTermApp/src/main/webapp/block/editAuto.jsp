<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<div class="bord">
<form action="editauto" accept="" method="post">
    <input type="hidden" name="id" value="<c:out value="${auto.id}"></c:out>"/>
    <table class="bordered">
        <tr>
            <td>Производитель</td>
            <td>
                <select name="id_brand" id="Select1" size="1" required>
                    <c:if test="${not empty brand}">
                    <c:forEach items="${brand}" var="brand">
                        <option value="<c:out value="${brand.id}"></c:out>" <c:if test="${brand.id==auto.id_brand}">SELECTED="" </c:if>><c:out value="${brand.brand}"></c:out></option>
                    </c:forEach>
                </select>
                </c:if></td>
        </tr>
        <tr>
            <td>Марка</td>
            <td><input type="text" name="model" value="<c:out value="${auto.model}"></c:out>"/></td>
        </tr>
        <tr>
            <td>Кузов</td>
            <td> <select name="id_types" id="Select2" size="1" required>
                <c:if test="${not empty types}">
                    <c:forEach items="${types}" var="types">
                        <option value="<c:out value="${types.id}"></c:out>" <c:if test="${types.id==auto.id_types}">SELECTED="" </c:if>><c:out value="${types.types}"></c:out></option>
                    </c:forEach>
                </c:if>  </select></td>
        </tr>
        <tr>
            <td>Число мест</td>
            <td><input type="text" name="seat"value="<c:out value="${auto.seat}"></c:out>"/></td>
        </tr>
        <tr>
            <td>Габариты(ВхШхД),мм</td>
            <td><input type="text" name="height" value="<c:out value="${auto.height}"></c:out>"/>x<input type="text" name="width"value="<c:out value="${auto.width}"></c:out>"/>x<input type="text" name="len"value="<c:out value="${auto.len}"></c:out>"/></td>
        </tr>
        <tr>
            <td>Рейтинг</td>
            <td><select name="rating" id="Sel" size="1" required>
                <c:forEach var="i" begin="1" end="10">
                    <option <c:if test="${i==auto.rating}">SELECTED="" </c:if>> <c:out value="${i}"/></option>
                </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td>Цена, от</td>
            <td><input type="text" name="price"value="<c:out value="${auto.price}"></c:out>"/></td>
        </tr>
        <tr>
            <td>Описание</td>
            <td><input type="textarea" name="descr" rows="3"value="<c:out value="${auto.descr}"></c:out>"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Запомнить изменения"/>
            </td>
        </tr>
    </table>
</form>
</div>

<c:if test="${not empty flag}">
    <script type="text/javascript">alert("Ошибка в данных, попробуйте еще раз...")</script>
</c:if>
