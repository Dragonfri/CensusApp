<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Register</title>
</head>
<body>
<%@ include file="MKYKBanner.jsp" %>
<div class="container">
    <form:form method="post" action="/register" modelAttribute="newuser" >
        <fieldset>
            <legend>Sign up</legend>
            <c:if test="${error.size() > 0}">
                <c:forEach var="err" items="${error}">
                    <div class="alert alert-dismissible alert-danger">
                            ${err}
                    </div>
                </c:forEach>
            </c:if>
            <div class="form-group">
                <label for="username">Username</label>
                <form:input path="username" type="text" class="form-control"  id="username" value="${user.username}" placeholder="Username" autofocus="true" />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:input path="password" type="password" class="form-control" id="password" value="${user.password}" placeholder="Password" />
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="email" type="email" class="form-control" id="email" value="${user.email}" placeholder="Email" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </fieldset>
    </form:form>
</div>
<%@ include file="MKYKFooter.jsp" %>
</body>
</html>