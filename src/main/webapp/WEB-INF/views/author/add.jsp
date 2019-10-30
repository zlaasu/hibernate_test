<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 2019-10-29
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h1>Author</h1>

<form:form method="POST" modelAttribute="author">

    <form:hidden path="id"/>

    <label>
        First name:
        <form:input path="firstName"/>
        <form:errors path="firstName" element="div" cssClass="error"/>
    </label>
    <br/><br/>

    <label>
        Last Name:
        <form:textarea path="lastName"/>
        <form:errors path="lastName" element="div" cssClass="error"/>
    </label>
    <br/><br/>

    <label>
        Email:
        <form:textarea path="email"/>
        <form:errors path="email" element="div" cssClass="error"/>
    </label>
    <br/><br/>

    <label>
        Pesel:
        <form:textarea path="pesel"/>
        <form:errors path="pesel" element="div" cssClass="error"/>
    </label>
    <br/><br/>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
