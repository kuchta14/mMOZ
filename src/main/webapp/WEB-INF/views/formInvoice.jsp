<%--
  Created by IntelliJ IDEA.
  User: kuchta
  Date: 06.09.2022
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wystaw fakturę</title>
    <style>
        .errors {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" action="/order/invoice" modelAttribute="invoice">
    <form:input type="hidden" path="order_number" value="${order}" /><br />
    First name: <form:input path="firstname" /><form:errors path="firstname" cssClass="errors"/><br />
    Last name: <form:input path="lastname" /><form:errors path="lastname" cssClass="errors"/><br />
    street: <form:input path="street" /><form:errors path="street" cssClass="errors"/><br />
    no: <form:input path="no" /><form:errors path="no" cssClass="errors"/><br />
    town: <form:input path="town" /><form:errors path="town" cssClass="errors"/><br />
    code: <form:input path="code" /><form:errors path="code" cssClass="errors"/><br />
    Nip: <form:input path="nip" /><form:errors path="nip" cssClass="errors"/><br />
    <button type="submit">Wystaw</button>
</form:form>
<c:out value="${dupa}"/>
</body>
</html>
