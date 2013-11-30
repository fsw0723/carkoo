<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ck" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/styles/style-guide.css"/>
</head>
<body>
<ck:header/>
<ck:menu/>
<div class="content">
    <ck:productDisplay/>
</div>

</body>
</html>