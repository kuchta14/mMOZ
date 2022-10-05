<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kuchta
  Date: 12.09.2022
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body class="bg-light">
<jsp:include page="navbar.jsp"/>
<br>
<div class="container-fluid bg-light">
    <div class="row">
        <div class="col-2 ">

        </div>
        <div class="col-4">
            <form method="POST" action="/login">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nawa użytkownika</label>
                    <input type="text" name="username" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                    <div id="" class="form-text"></div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Hasło</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary">Zaloguj</button>
            </form>
        </div>

        <div class="col-4">
            <form:form method="POST" action="/create-user" modelAttribute="user" class="row g-3">
            <div class="mb-3">
                <label  class="form-label">Nazwa użytkownika</label>
                <form:input path="username" type="text" class="form-control" />
            </div>
            <div class="mb-3">
                <label  class="form-label">Hasło</label>
                <form:input path="password" type="password" class="form-control" />
            </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Zarejestruj</button>
        </div>
        </div>
        </form:form>
    </div>
</div>
<c:out value="${success}"/>
<jsp:include page="footer.jsp"/>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
</body>
</html>
