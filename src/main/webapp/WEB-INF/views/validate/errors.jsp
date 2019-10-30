<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../include/head.jsp" />

<h1>Book Erros</h1>

<%--<c:if test="${test}"--%>

<c:forEach items="${fieldErrors}" var="error">
    <p><b>Path:</b> ${error.path}, <b>message:</b> ${error.message} </p>
</c:forEach>

</body>
</html>
