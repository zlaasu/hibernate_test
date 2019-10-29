<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 2019-10-29
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Are do you whand to delete book <b>${book.title}?</b></p>


<a href="/book/list">NIE!!!!</a>

<a href="/book/delete/${book.id}">TAK!!!!</a>

</body>
</html>
