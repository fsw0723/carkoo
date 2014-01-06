<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ck" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/styles/style-guide.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/styles/product.css"/>
</head>
<body class="body">
    <div class="row">
        <ck:header/>
    </div>
    <div class="row">
        <ck:menu/>
    </div>
    <div class="content">
        <ck:productDisplay cars="${cars}"></ck:productDisplay>
    </div>

</body>
</html>