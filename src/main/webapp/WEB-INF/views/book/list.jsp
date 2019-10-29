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
    <p><b>Rating: </b>${book.rating}</p>
    <p><b>Publisher: </b>${book.publisher.name}</p>

    <p><b>Actions</b></p>
    <p><a href="/book/edit/${book.id}">EDIT</a></p>
    <p><a href="/book/confirmDelete/${book.id}">DELETE</a></p>

    <hr>
</c:forEach>

</body>
</html>
