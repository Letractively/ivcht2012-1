<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 10.12.12
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<form name="f1"  action="adduser">
    <table class="bordered"> <tr><td>Пользователь</td>
        <td><input type="text" name="user"/></td>
    </tr>
    <tr><td>Пароль</td>
        <td><input type="text" name="pass"/></td>
    </tr>
        <tr>
            <td>Доступ</td>
            <td><select name="kontrol" id="Select2" size="1" required>
                <option value="1">Администратор</option>
                <option value="0">Пользователь</option>
            </select></td>
        </tr>
    <tr>
        <td></td>
        <td>
            <input type="submit" value="Добавить"/>
        </td>
    </tr>

    </table>
</form>
<form name="f2" action="deleteuser">
<table class="bordered">
    <tr>
        <th>ID</th>
        <th>Пользователь</th>
        <th>Пароль</th>
        <th>Права</th>
    </tr>
    <c:forEach items="${users}" var="usr">
    <tr>
        <td><c:out value="${usr.user_id}"></c:out></td>
        <td><c:out value="${usr.user_login}"></c:out></td>
        <td> <c:out value="${usr.user_password}"></c:out> </td>
        <td>< <c:out value="${usr.prava}"></c:out> </td>
        <td><input type="checkbox" name="check<c:out value='${usr.id}'></c:out>" checked="checked"/></td>
    </tr>
    </c:forEach>
</form>
