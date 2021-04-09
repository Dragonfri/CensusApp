<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>MKYKCensusApp</title>
</head>
<body>
<%@ include file="MKYKBanner.jsp" %>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-3">PROG3060</h1>
        <p class="lead">Java Enterprise Application</p>
        <hr class="my-4">
        <p>Michael Kariuki</p>
        <p>Young Geun Kim</p>
        <p class="lead">
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <a class="btn btn-primary btn-lg" href="/goToLogin" role="button">Sign in</a>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-primary btn-lg" href="/logout" role="button">Sign out</a>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
</div>
<%@ include file="MKYKFooter.jsp" %>
</body>
</html>
