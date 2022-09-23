<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders list</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<table class="table">
    <tr>
        <th>Numer Zamówienia</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Data utworzenia</th>
    </tr>
    <c:forEach items="${orders}" var="a">
        <tr>
            <td><a href="<c:url value="/order/${a.order_number}"/>">${a.order_number}</a></td>
            <td><c:out value="${a.firstname}"/></td>
            <td><c:out value="${a.lastname}"/></td>
            <td><c:out value="${a.create_data}"/></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/all"/>">Pokaż Wszystkie</a>
<a href="<c:url value="/form/order"/>">Złóż zamówienie</a>
<a href="<c:url value="/logout"/>">Wyloguj</a>
</body>
</html>