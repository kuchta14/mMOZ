<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Złóż zamówienie</title>
</head>
<body>
<form:form method="post" action="/setOrder" modelAttribute="order">
    First name: <form:input path="firstname" /><br />
    Last name: <form:input path="lastname" /><br />
    street: <form:input path="street" /><br />
    no: <form:input path="no" /><br />
    town: <form:input path="town" /><br />
    code: <form:input path="code" /><br />
    Products: <form:select path="products" items="${products}" multiple="true" /><br />
    <button type="submit">Save</button>
</form:form>
</body>
</html>
