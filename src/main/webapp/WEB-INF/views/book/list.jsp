<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 2019-10-29
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Book list</h1>


<c:forEach items="${books}" var="book">
    <p><b>Id: </b>${book.id}</p>

    <p><b>Title: </b>${book.title}</p>

    <p><b>Description</b></p>
    <p>${book.description}</p>

    <hr>
</c:forEach>

</body>
</html>
