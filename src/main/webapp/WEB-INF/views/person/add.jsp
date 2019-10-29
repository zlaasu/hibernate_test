<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 2019-10-29
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>

<h1>Add person</h1>

<form:form method="POST" modelAttribute="person">
    <label>
        Login:
        <form:input path="login"/>
    </label>
    <br/><br/>
    <label>
        Password:
        <form:password path="password"/>
    </label>
    <br/><br/>
    <label>
        Email:
        <form:input path="email"/>
    </label>
    <br/><br/>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
