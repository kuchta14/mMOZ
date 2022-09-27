<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Złóż zamówienie</title>
    <style>
        .errors {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" action="/setOrder" modelAttribute="order">
    First name: <form:input path="firstname"/><form:errors path="firstname" cssClass="errors"/><br />
    Last name: <form:input path="lastname" /><form:errors path="lastname" cssClass="errors"/><br />
    street: <form:input path="street" /><form:errors path="street" cssClass="errors"/><br />
    no: <form:input path="no" /><form:errors path="no" cssClass="errors"/><br />
    town: <form:input path="town" /><form:errors path="town" cssClass="errors"/><br />
    code: <form:input path="code" /><form:errors path="code" cssClass="errors"/><br />
    Products: <form:select path="products" items="${products}" multiple="true" /><br />
    <button type="submit">Save</button>
</form:form>
</body>
</html>
