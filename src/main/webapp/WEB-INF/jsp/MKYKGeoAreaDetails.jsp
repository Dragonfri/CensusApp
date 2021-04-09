<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ykim1059
  Date: 2/20/2020
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Details</title>
</head>
<body>
<%@ include file="MKYKBanner.jsp" %>
<div class="container">
    <h3 style="text-align: center; margin: 35px;">Geographic Area Details</h3>
    <div class="card border-primary mb-3" style="max-width: 20rem; margin: auto;">
        <div class="card-header" style="background-color: #2C3E50; color: #ffffff;"><em>${geo.name}</em></div>
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th scope="row">Geographic Area ID: </th>
                    <td align="right">${geo.geographicAreaId}</td>
                </tr>
                <tr>
                    <th scope="row">Code: </th>
                    <td align="right">${geo.code}</td>
                </tr>
                <tr>
                    <th scope="row">Level: </th>
                    <td align="right">${geo.level}</td>
                </tr>
                <tr>
                    <th scope="row">Alternative Code: </th>
                    <td align="right">${geo.alternativeCode}</td>
                </tr>
                <tr>
                    <th scope="row">Total Population: </th>
                    <td align="right">${combined}</td>
                </tr>
                <tr>
                    <th scope="row">Male: </th>
                    <td align="right">${male}</td>
                </tr>
                <tr>
                    <th scope="row">Female: </th>
                    <td align="right">${female}</td>
                </tr>
            </table>
            <button type="button" onclick="window.history.back()" class="btn btn-primary btn-lg btn-block">
                Back
            </button>
        </div>
    </div>
</div>
<%@ include file="MKYKFooter.jsp" %>
</body>
</html>