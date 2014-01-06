<%@ taglib prefix="ck" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="cars" type="java.util.ArrayList" %>
<div class="grid">
    <ul>
        <c:forEach items="${cars}" var="car">
            <li>
                <ck:product car="${car}"/>
            </li>
        </c:forEach>

    </ul>
</div>