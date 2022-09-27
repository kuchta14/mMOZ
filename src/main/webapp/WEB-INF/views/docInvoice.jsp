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
</head>
<body>
<c:out value="${invoice.order_number}"/>
<c:out value="${invoice.firstname}"/>
<c:out value="${invoice.lastname}"/>
<c:out value="${invoice.street}"/>
<c:out value="${invoice.no}"/>
<c:out value="${invoice.town}"/>
<c:out value="${invoice.code}"/>
<c:out value="${invoice.nip}"/>
<c:out value="${invoice.status}"/>
<c:out value="${invoice.create_data}"/>
</body>
</html>
