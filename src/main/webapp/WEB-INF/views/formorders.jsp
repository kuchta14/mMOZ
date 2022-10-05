<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Złóż zamówienie</title>
    <style>
        .errors {
            color: red;
        }
    </style>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<%--<div class="py-5 text-center">--%>
<div class="py-5 text-center">
<div class="col-md-7">
    <h4 class="mb-3">Formularz zamówienia</h4>
<form:form class="needs-validation"  method="post" action="/setOrder" modelAttribute="order">
<%--    <form class="needs-validation" novalidate="">--%>
        <div class="row g-3">
            <div class="col-sm-6">
                <label class="form-label">Imię</label>
                <form:input type="text" class="form-control"  path="firstname"/><form:errors path="firstname" cssClass="errors"/>
<%--                <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">--%>
            </div>

            <div class="col-sm-6">
                <label class="form-label">Nazwisko</label>
                <form:input type="text" class="form-control" path="lastname" /><form:errors path="lastname" cssClass="errors"/>
<%--                <input type="text" class="form-control" id="lastName" placeholder="" value="" required="">--%>
            </div>

            <div class="col-sm-6">
                <label class="form-label">Ulica</label>
                <div class="input-group has-validation">
                    <form:input type="text" class="form-control"  path="street" /><form:errors path="street" cssClass="errors"/>
<%--                    <input type="text" class="form-control" id="username" placeholder="Username" required="">--%>
                </div>
            </div>

            <div class="col-md-3">
                <label class="form-label">Nr</label>
                <form:input type="text" class="form-control"  path="no" /><form:errors path="no" cssClass="errors"/>
<%--                <input type="email" class="form-control" id="email" placeholder="you@example.com">--%>
            </div>

            <div class="col-sm-6">
                <label class="form-label">Miasto</label>
                <form:input type="text" class="form-control" path="town" /><form:errors path="town" cssClass="errors"/>
<%--                <input type="text" class="form-control" id="address" placeholder="1234 Main St" required="">--%>
            </div>

            <div class="col-md-3">
                <label for="code" class="form-label">Kod Pocztowy</label>
                <form:input type="text" class="form-control" path="code" /><form:errors path="code" cssClass="errors"/>
                    <%--                <input type="text" class="form-control" id="zip" placeholder="" required="">--%>
            </div>

            <div class="col-md-5">
                <label  class="form-label">Produkty</label>
                <form:select class="form-select" path="products" items="${products}" multiple="true"/>
            </div>
            <c:out value="${prod}"/>
        </div>

        <hr class="my-4">

        <button class="w-50 btn btn-primary btn-lg" type="submit">Wyślij</button>
<%--    </form>--%>
</form:form>
<%--</div>--%>
</div>
</div>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>
