<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 2019-10-29
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>

<c:forEach items="${authors}" var="author">
    <p><b>Id: </b>${author.id}</p>
    <p><b>First name: </b>${author.firstName}</p>
    <p><b>Last name: </b>${author.lastName}</p>

    <p><b>Actions:</b>
        <a href="/author/edit/${author.id}">EDIT</a> |
        <a href="/author/delete/${author.id}">DELETE</a>
    </p>

    <hr>
</c:forEach>

</body>
</html>
