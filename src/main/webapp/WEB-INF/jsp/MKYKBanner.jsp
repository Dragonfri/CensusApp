<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">MKYKCensusApp</a>

    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/home">Home</a>
            </li>
            <c:if test="${sessionScope.user == null}">
                <li class="nav-item">
                    <a class="nav-link" href="/goToLogin">Sign in</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="/goToLevel">Search by level</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/goToKeyword">Search by keyword</a>
            </li>
            <c:if test="${sessionScope.user != null}">
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Sign out</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>