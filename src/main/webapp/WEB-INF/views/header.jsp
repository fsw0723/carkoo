<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="logo">
    this is header
</div>
<div class="login">
    <sec:authorize var="loggedIn" access="isAuthenticated()" />
    <c:choose>
        <c:when test="${loggedIn}">
            Hello ${username}
            <a href="/j_spring_security_logout">Logout</a>
        </c:when>
        <c:otherwise>
            <a href="/login">Login</a>
        </c:otherwise>
    </c:choose>
</div>
