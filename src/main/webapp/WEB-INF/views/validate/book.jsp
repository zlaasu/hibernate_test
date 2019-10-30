<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 2019-10-30
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Book Erros</h1>

<c:forEach items="${fieldErrors}" var="error">
    <p><b>Path:</b> ${error.path}, <b>message:</b> ${error.message} </p>
</c:forEach>

</body>
</html>
