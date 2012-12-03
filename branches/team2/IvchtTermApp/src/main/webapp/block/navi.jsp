<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

   <c:if test="${empty autos}">
       <jsp:forward page="/listauto"/>
   </c:if>

   <table class="example">
       <tr>
           <th>Марка</th>
           <th>Модель</th>
           <th>Число мест</th>
           <th>Габариты</th>
           <th>Описание</th>
           <th>Рейтинг</th>
           <th>Цена</th>


       </tr>
       <c:forEach items="${autos}" var="auto">
           <tr>
               <td><c:out value="${auto.brand}"></c:out></td>
               <td><a href="listpackage?tps=<c:out value="${auto.id}"></c:out>"><c:out value="${auto.model}"></c:out></a></td>
               <td><c:out value="${auto.seat}"></c:out></td>
               <td><c:out value="${auto.len}"></c:out>x<c:out value="${auto.width}"></c:out>x<c:out value="${auto.height}"></c:out></td>
               <td><c:out value="${auto.descr}"></c:out></td>
               <td><c:out value="${auto.rating}"></c:out></td>
               <td><c:out value="${auto.price}"></c:out></td>
           </tr>
       </c:forEach>
   </table>

