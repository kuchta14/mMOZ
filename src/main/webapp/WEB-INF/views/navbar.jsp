<%--
  Created by IntelliJ IDEA.
  User: kucht
  Date: 27.09.2022
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet"
        href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body>
<header class="p-3 text-bg-dark">
<div class="container">
  <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
    <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
      <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
    </a>

    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
      <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
      <li><a href="/form/order" class="nav-link px-2 text-white">Złóż zamówienie</a></li>
      <li><a href="/all" class="nav-link px-2 text-white">Pokaż wszystkie zamówienia</a></li>
    </ul>
    <sec:authorize access="isAuthenticated()">
      <p class="text-light me-2">Zalogowany jako: <sec:authentication property="principal.username"/></p>
      <div class="text-end">
      <form class="me-2" action="<c:url value="/logout"/>" method="post">
        <input class="btn btn-outline-light" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </form>
    </div>
    </sec:authorize>

<sec:authorize access="isAnonymous()">
    <div class="text-end">
      <a href="/login" class="btn btn-outline-light me-2">Zaloguj</a>
    </div>
  </div>
  </sec:authorize>
</div>
</header>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.js"></script>
<script src="/webjars/bootstrap/5.2.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
