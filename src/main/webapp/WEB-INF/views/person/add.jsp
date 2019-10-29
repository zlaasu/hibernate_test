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

<form method="POST">
    <label>
        Login:
        <input type="text" name="login"/>
    </label>
    <br/><br/>
    <label>
        Password:
        <input type="password" name="password"/>
    </label>
    <br/><br/>
    <label>
        Email:
        <input type="email" name="email"/>
    </label>
    <br/><br/>

    <input type="submit" value="Save"/>
</form>

</body>
</html>
