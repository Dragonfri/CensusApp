<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>MKYK Geographic Area by Keyword</title>
</head>
<body>
<%@ include file="MKYKBanner.jsp" %>
<form action="/searchByKeyword" method="get">
    <fieldset>
        <div class="form-group">
            <label class="col-form-label" for="inputDefault">Find Geographic Area by Keyword</label>
            <input type="text" path="searchByKeyword" name="mkyk_keyword" class="form-control" placeholder="Enter a keyword" id="inputDefault" value="${currentKeyword}">
        </div>
        <input type="submit" class="btn btn-primary" value="Search">
    </fieldset>
</form>
<table>
    <tr>
        <th>Geo Area ID</th>
        <th>Code</th>
        <th>Level</th>
        <th>Name</th>
        <th>Alt Code</th>
    </tr>
    <c:forEach var="area" items="${mkyk_geoList}">
        <tr>
            <td>${area.geographicAreaId}</td>
            <td>${area.code}</td>
            <td>${area.level}</td>
            <td><a href="/details?mkyk_altcode=${area.alternativeCode}">${area.name}</a></td>
            <td>${area.alternativeCode}</td>
        </tr>
    </c:forEach>
</table>
<%@ include file="MKYKFooter.jsp"%>
</body>
</html>
