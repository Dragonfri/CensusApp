<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>MKYK Geographic Area by Level</title>
</head>
<body>
<%@ include file="MKYKBanner.jsp" %>
<div class="container">
    <form action="/searchByLevel" method="get">
        <div class="form-group">
            <label for="level">Find Geographic Area by Level</label>
            <select path="searchByLevel" class="form-control" id="level" name="mkyk_level">
                <c:choose>
                    <c:when test="${currentLevel==0}">
                        <option value="0" selected>0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                    </c:when>
                    <c:when test="${currentLevel==1}">
                        <option value="0">0</option>
                        <option value="1" selected>1</option>
                        <option value="2">2</option>
                    </c:when>
                    <c:when test="${currentLevel==2}">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2" selected>2</option>
                    </c:when>
                    <c:otherwise>
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        <input type="submit" class="btn btn-primary" value="Search">
    </form>
    <table class="table table-hover">
        <thead>
        <tr class="table-primary">
            <th scope="col">GeoAreaID</th>
            <th scope="col">Code</th>
            <th scope="col">Level</th>
            <th scope="col">Name</th>
            <th scope="col">AltCode</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="geo" items="${mkyk_geoList}">
            <tr>
                <td>${geo.geographicAreaId}</td>
                <td>${geo.code}</td>
                <td>${geo.level}</td>
                <td><a class="details-link" href="/details?id=${geo.alternativeCode}">${geo.name}</a></td>
                <td>${geo.alternativeCode}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="MKYKFooter.jsp" %>
</body>
</html>
