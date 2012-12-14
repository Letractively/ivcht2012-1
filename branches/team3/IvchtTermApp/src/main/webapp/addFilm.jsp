﻿ <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %><html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Добавление нового кинофильма</title>


    <link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />

</head>
<body>
<div id="art-page-background-glare">
    <div id="art-page-background-glare-image"> </div>
</div>
<div id="art-main">
    <div class="cleared reset-box"></div>
    <div class="art-sheet">
        <div class="art-sheet-tl"></div>
        <div class="art-sheet-tr"></div>
        <div class="art-sheet-bl"></div>
        <div class="art-sheet-br"></div>
        <div class="art-sheet-tc"></div>
        <div class="art-sheet-bc"></div>
        <div class="art-sheet-cl"></div>
        <div class="art-sheet-cr"></div>
        <div class="art-sheet-cc"></div>
        <div class="art-sheet-body">
            <div class="art-header">
                <div class="art-header-clip">
                <div class="art-header-center">
                    <div class="art-header-png"></div>
                    <div class="art-header-jpeg"></div>
                </div>
                </div>
                <div class="art-textblock"> </div>
                <div class="art-headerobject"></div>
                <script type="text/javascript" src="swfobject.js"></script>
                <div id="art-flash-area">
                <div id="art-flash-container">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="792" height="150" id="art-flash-object">
                	<param name="movie" value="../container.swf" />
                	<param name="quality" value="high" />
                	<param name="scale" value="default" />
                	<param name="wmode" value="transparent" />
                	<param name="flashvars" value="color1=0xFFFFFF&amp;alpha1=.50&amp;framerate1=24&amp;loop=true&amp;wmode=transparent&amp;clip=../images/flash.swf&amp;radius=5&amp;clipx=0&amp;clipy=-16&amp;initalclipw=900&amp;initalcliph=225&amp;clipw=900&amp;cliph=225&amp;width=792&amp;height=150&amp;textblock_width=0&amp;textblock_align=no&amp;hasTopCorners=true&amp;hasBottomCorners=false" />
                    <param name="swfliveconnect" value="true" />
                	<!--[if !IE]>-->
                	<object type="application/x-shockwave-flash" data="container.swf" width="792" height="150">
                	    <param name="quality" value="high" />
                	    <param name="scale" value="default" />
                	    <param name="wmode" value="transparent" />
                    	<param name="flashvars" value="color1=0xFFFFFF&amp;alpha1=.50&amp;framerate1=24&amp;loop=true&amp;wmode=transparent&amp;clip=resources/images/flash.swf&amp;radius=5&amp;clipx=0&amp;clipy=-16&amp;initalclipw=900&amp;initalcliph=225&amp;clipw=900&amp;cliph=225&amp;width=792&amp;height=150&amp;textblock_width=0&amp;textblock_align=no&amp;hasTopCorners=true&amp;hasBottomCorners=false" />
                        <param name="swfliveconnect" value="true" />
                	
                		<div class="art-flash-alt"><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" /></a></div>
                  
                	</object>
                  
                </object>
                </div>
                </div>
                <script type="text/javascript">    swfobject.switchOffAutoHideShow(); swfobject.registerObject("art-flash-object", "9.0.0", "expressInstall.swf");</script>
                <div class="art-logo">
                                 <h1 class="art-logo-name"><a href="index.jsp">Кино -</a></h1>
                                                 <h2 class="art-logo-text">это жизнь, из которой                  вырезано всё скучное</h2>
                                </div>
            </div>
            <div class="cleared reset-box"></div>
<div class="art-nav">
	<div class="art-nav-l"></div>
	<div class="art-nav-r"></div>
<div class="art-nav-outer">
	<ul class="art-hmenu">
		<li>
			<a href="index.jsp"><span class="l"></span><span class="r"></span><span class="t">Главная</span></a>
		</li>	
		<li>
			<a href="genres.jsp"><span class="l"></span><span class="r"></span><span class="t">Жанры</span></a>
			<ul>
				<li>
                    <a href="genresList.jsp">Список жанров</a>

                </li>
				<li>
                    <a href="addGenre.jsp">Добавить жанр</a>

                </li>
			</ul>
		</li>	
		<li>
			<a href="films.jsp" class="active"><span class="l"></span><span class="r"></span><span class="t">Кинофильмы</span></a>
			<ul>
				<li>
                    <a href="filmList">Список кинофильмов</a>

                </li>
				<li>
                    <a href="genreList?i=1" class="active">Добавить кинофильм</a>

                </li>
			</ul>
		</li>	
	</ul>
</div>
</div>
<div class="cleared reset-box"></div>
<div class="art-content-layout">
                <div class="art-content-layout-row">
                    <div class="art-layout-cell art-content">
<div class="art-post">
    <div class="art-post-body">
<div class="art-post-inner art-article">
                                <h2 class="art-postheader">
                Добавление нового кинофильма
                                </h2>
                                


    <form action="addFilm" method="post">
        <table class="art-article" border="0" cellspacing="0" cellpadding="0" style="width:100%;"><tbody >
            <tr>
                <td> Наименование</td>
                <td><input type="text" name="name"/></td>
            </tr>
             <tr>
                <td>жанр</td>
                <td>

                    <select name="genreId">
                        <option disabled>Выберите жанр</option>
                        <c:forEach items="${genres}" var="genre">
                            <option value="<c:out value='${genre.id}'></c:out>"><c:out value="${genre.name}"></c:out></option>
                        </c:forEach>
                    </select>

                </td>

            </tr>
            <tr> 
            <tr>
                <td>Описание</td>
                <td><input type="text" name="info" /></td>
            </tr>
            <tr>
                <td>Страна</td>
                <td><input type="radio" name="country" checked="checked" value="Россия"/>Россия</td>
                <td><input type="radio" name="country" value="Италия"/>Италия</td>
                <td><input type="radio" name="country" value="Франци"/>Франция</td>
                <td><input type="radio" name="country" value="Германия"/>Германия</td>
                <td><input type="radio" name="country" value="Америк"/>Америка</td>
                <td><input type="radio" name="country" value="Другое"/>Другое</td>
            </tr>
            <tr>
                <td>3D</td>
                <td><input type="checkbox" name="d3" checked="checked" value="1"/>Есть в 3D</td>
            </tr>
            <tr>
                <td>Дата выхода(01.01.1900)</td>
                <td><input type="text" name="date" /></td>
            </tr>
                         
                <td>
                    <input type="submit" value="Добавить"/>
                    <input type="reset" value="Очистить"/>
                </td>
            </tr>
     </tbody>   </table>
    </form>

    <c:if test="${not empty result}">
        <span> <c:out value="${result}"></c:out></span>
    </c:if>

    <c:if test="${not empty error}">
        <span class="error"><c:out value="${error}"></c:out></span>
    </c:if>

    <br/>
    <br/>

    <a href="filmList.jsp">К списку фильмов</a><br/>
    <a href="index.jsp">На главную</a><br/>



                <div class="cleared"></div>
                                <div class="art-postcontent">

<p><br /></p>


                </div>
                <div class="cleared"></div>
                </div>

		<div class="cleared"></div>
    </div>
</div>

                      <div class="cleared"></div>
                    </div>
                </div>
            </div>
            <div class="cleared"></div>
            <div class="art-footer">
                <div class="art-footer-t"></div>
                <div class="art-footer-l"></div>
                <div class="art-footer-b"></div>
                <div class="art-footer-r"></div>
                <div class="art-footer-body">
                            <div class="art-footer-text">
                                

                                                            </div>
                    <div class="cleared"></div>
                </div>
            </div>
    		<div class="cleared"></div>
        </div>
    </div>
    <div class="cleared"></div>
    <p class="art-page-footer"></p>
    <div class="cleared"></div>
</div>

</body>
</html>
