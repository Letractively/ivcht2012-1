<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <link rel=stylesheet href="resources/css/base.css" type="text/css">
</head>
<title>Автомобили1</title>
<body>
<div class="block">
    <div id="head"><jsp:include page="block/head.jsp"></jsp:include></div>
    <div id="navi" class="nav"><jsp:include page="block/navi.jsp"></jsp:include></div>
    <div id="left" class="links"><jsp:include page="block/left.jsp"></jsp:include></div>
    <div id="cont"><jsp:include page="block/addAuto.jsp"></jsp:include> </div>
    <div id="foot"><jsp:include page="block/foot.jsp"></jsp:include> </div>
</div>
</body>
</html>