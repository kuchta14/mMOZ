<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mini MOZ</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<br>
<table class="table table-striped">
    <colgroup>
        <col width="15.1%">
        <col width="12.6%">
        <col width="12.8%">
        <col width="18.5%">
        <col width="18.5%">
        <col width="18.5%">
    </colgroup>
    <thead class="thead-dark">
    <tr>
        <th>Numer Zamówienia</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Data utworzenia</th>
        <th>Płatność</th>
        <th>Faktura</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="a">
        <tr>
            <td><a href="<c:url value="/order/${a.order_number}"/>">${a.order_number}</a></td>
            <td><c:out value="${a.firstname}"/></td>
            <td><c:out value="${a.lastname}"/></td>
            <td><c:out value="${a.create_data}"/></td>

        </tr>
    </c:forEach>
    <c:forEach items="${invoicenr}" var="b">
        <tr>
            <td><c:out value="${b}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>