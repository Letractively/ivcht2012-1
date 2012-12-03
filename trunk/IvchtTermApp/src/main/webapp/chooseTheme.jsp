<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
    <link rel=stylesheet href="resources/themes/theme<c:out value="${sessionScope.theme}"/>/theme.css" type="text/css">
</head>
<body>
    <h1>Страница выбора темы</h1>

    <hr class="full">
    <p class="message">
        Здесь вы можете выбрать одну из возможных тем.
    </p>

    <form action="chooseTheme" method="POST">
        <c:forEach var="i" begin="1" end="${sessionScope.themeCount}">
            <c:out value="${i}"/>:
            <input type="radio" name="theme" value="<c:out value='${i}'/>"
                   <c:if test="${sessionScope.theme eq i}">checked="checked" </c:if>
            >
            <br/>
        </c:forEach>
        <input type="submit" value="Сменить тему">
    </form>
    <a href="index.jsp">Вернуться на главную</a>
</body>
</html>