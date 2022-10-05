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
    <title>Szczegóły zamówienia</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<br>
<h4 class="mb-3">Zlecenie Nr <c:out value="${order.order_number}"/></h4>
<a class="badge bg-primary rounded-pill text-bg-dark" href="<c:url value="/order/invoice/${order.order_number}"/>">Wystaw fakturę</a>
<a class="badge bg-primary rounded-pill text-bg-dark" href="<c:url value="/order/invoice/doc/${order.order_number}"/>">Dokumenty</a>
<c:out value="${faktura}"/>
<a class="badge bg-primary rounded-pill text-bg-dark" href="<c:url value="/retryorder/${order.order_number}"/>">Ponów</a>
<br>
<br>
<form:form method="PUT" action="/order/cancel/${order.order_number}" >
    <button class="badge bg-primary rounded-pill text-bg-dark" type="submit">Anuluj zamówienie</button>
</form:form>

<%--<h4 class="d-flex justify-content-between align-items-center mb-3">--%>
<%--    <span class="badge bg-primary rounded-pill text-bg-success"><c:out value="${order.status}"/></span>--%>
<%--</h4>--%>
<br>
<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">Imie</th>
        <th scope="col">Nazwisko</th>
        <th scope="col">Ulica</th>
        <th scope="col">Nr</th>
        <th scope="col">Miasto</th>
        <th scope="col">Kod pocztowy</th>
        <th scope="col">Data Utworzenia</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th><c:out value="${order.firstname}"/></th>
        <td><c:out value="${order.lastname}"/></td>
        <td><c:out value="${order.street}"/></td>
        <td><c:out value="${order.no}"/></td>
        <td><c:out value="${order.town}"/></td>
        <td><c:out value="${order.code}"/></td>
        <td><c:out value="${order.create_data}"/></td>
        <td><c:out value="${order.status}"/></td>
    </tr>
    </tbody>
</table>
<br>
    <div class="card" style="width: 18rem;">
        <%--        <img src="<c:out value="${a.url}"/>" class="flex-shrink-0 me-3" alt="...">--%>
        <div class="card-body">
            <h5 class="card-title">Produkty</h5>
<%--                        <p class="card-text"><c:out value="${a.name}"/></p>--%>
        </div>
<%--                <div class="card-footer">--%>
<%--                    <h6 class="card-title">Brutto</h6>--%>
<%--                    <small class="text-muted"><c:out value="${a.price}"/></small>--%>
<%--                </div>--%>

<c:forEach items="${products}" var="a">

    <ol class="list-group">
<%--        <img src="<c:out value="${a.url}"/>" class="mw-10" alt="...">--%>
        <li class="list-group-item"><c:out value="${a.name}"/>
            -Brutto:<small class="text-muted"><c:out value="${a.price}"/></small></li>
    </ol>

</c:forEach>

<div class="card-footer">
    <h6 class="card-title">Suma</h6>
    <small class="text-muted"><c:out value="${suma}"/></small>
</div>

    </div>
<br>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>
