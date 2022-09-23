<%--
  Created by IntelliJ IDEA.
  User: kuchta
  Date: 06.09.2022
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/order/invoice" modelAttribute="invoice">
    <form:input path="order_number" value="${order}" /><br />
    First name: <form:input path="firstname" /><br />
    Last name: <form:input path="lastname" /><br />
    street: <form:input path="street" /><br />
    no: <form:input path="no" /><br />
    town: <form:input path="town" /><br />
    code: <form:input path="code" /><br />
    Nip: <form:input path="nip" /><br />
    <button type="submit">Wystaw</button>
</form:form>
</body>
</html>
