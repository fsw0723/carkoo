<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ck" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/styles/style-guide.css"/>
</head>
<body>
<div class="row">
    <jsp:include page="header.jsp"/>
</div>
<div class="content">
    <form name="registerForm" method="post">
        <div><label>Username</label> <input name="username"/></div>
        <div><label>Password</label> <input name="password" type="password"/></div>
        <div><label>Confirm Password</label> <input name="confirmPassword" type="password"/></div>
        <input type="submit" value="submit"/>
    </form>
</div>
</body>
</html>
