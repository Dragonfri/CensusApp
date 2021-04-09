<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Welcome</title>
</head>
<body>
<%@ include file="MKYKBanner.jsp" %>
<div class="container">
    <div class="jumbotron">
        <h5 class="display-3">WELCOME, ${user.username}</h5>
        <hr class="my-4">
        <p class="lead">
            <c:choose>
                <c:when test="${user.lastGeographicArea == 0}">
                    <button class="btn btn-primary btn-lg" disabled>Go to details</button>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-primary btn-lg" href="/details?id=${user.lastGeographicArea}" role="button">Go to details</a>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
</div>
<%@ include file="MKYKFooter.jsp" %>
</body>
</html>