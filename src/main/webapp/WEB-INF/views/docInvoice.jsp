<%--
  Created by IntelliJ IDEA.
  User: kucht
  Date: 26.09.2022
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<br>
<h4 class="mb-3">Zlecenie Nr <c:out value="${invoice.order_number}"/></h4>
<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">Nr FAV</th>
        <th scope="col">Imię</th>
        <th scope="col">Nazwisko</th>
        <th scope="col">Ulica</th>
        <th scope="col">Nr</th>
        <th scope="col">Miasto</th>
        <th scope="col">Kod pocztowy</th>
        <th scope="col">Nip</th>
        <th scope="col">Status</th>
        <th scope="col">Data Utworzenia</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>FAV/<c:out value="${invoice.id}"/>/2022</td>
        <td><c:out value="${invoice.firstname}"/></td>
        <td><c:out value="${invoice.lastname}"/></td>
        <td><c:out value="${invoice.street}"/></td>
        <td><c:out value="${invoice.no}"/></td>
        <td><c:out value="${invoice.town}"/></td>
        <td><c:out value="${invoice.code}"/></td>
        <td><c:out value="${invoice.nip}"/></td>
        <td><c:out value="${invoice.status}"/></td>
        <td><c:out value="${invoice.create_data}"/></td>
    </tr>
    </tbody>
</table>
<br>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>
