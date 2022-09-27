<%--
  Created by IntelliJ IDEA.
  User: kuchta
  Date: 06.09.2022
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="PUT" action="/order/cancel/${order.order_number}" >
    <button type="submit">Anuluj zamówienie</button>
</form:form>
<a href="<c:url value="/order/invoice/${order.order_number}"/>">Wystaw fakturę</a>
<a href="<c:url value="/order/invoice/doc/${order.order_number}"/>">Dokumenty</a>
<a href="<c:url value="/retryorder/${order.order_number}"/>">Ponów</a>
<br>
<c:out value="${order.order_number}"/>
<c:out value="${order.firstname}"/>
<c:out value="${order.lastname}"/>
<c:out value="${order.street}"/>
<c:out value="${order.no}"/>
<c:out value="${order.town}"/>
<c:out value="${order.code}"/>
<c:out value="${order.status}"/>
<c:out value="${order.create_data}"/>
<c:forEach items="${products}" var="a">
<c:out value="${a.name}"/>
<c:out value="${a.price}"/>
</c:forEach>
<br>
<a href="<c:url value="/"/>">Wszystkie zamówienia</a>
</body>

</html>
