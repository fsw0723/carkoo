<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Login
<form method="post" action="<c:url value='j_spring_security_check'/>" name="login_form"/>
    Username
    <input type="text" name="j_username"/>
    Password
    <input type="password" name="j_password"/>
    <input type="submit" name="submit" value="submit"/>
</form>

</body>
</html>
