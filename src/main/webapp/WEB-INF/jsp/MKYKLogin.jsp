<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Menu</title>
</head>
<body>
<%@ include file="MKYKBanner.jsp" %>
<div class="container">
    <form:form method="POST" action="/login" modelAttribute="login">
        <fieldset>
            <legend>Sign in</legend>
            <c:if test="${error != null}">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert"></button>
                        ${error}
                </div>
            </c:if>
            <div class="form-group">
                <form:input path="username" type="text" class="form-control"  id="username" placeholder="Username" autofocus="true" />
            </div>
            <div class="form-group">
                <form:input path="password" type="password" class="form-control" id="password" placeholder="Password" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <p>Don't have an account? <a href="/goToRegister">Sign up</a></p>
        </fieldset>
    </form:form>
</div>
<%@ include file="MKYKFooter.jsp" %>
</body>
</html>