<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 2019-10-29
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Add book</h1>

<form:form method="POST" modelAttribute="book">

    <form:hidden path="id"/>

    <label>
        Title:
        <form:input path="title"/>
    </label>
    <br/><br/>

    <label>
        Description:
        <form:textarea path="description"/>
    </label>
    <br/><br/>

    <label>
        Rating:
        <form:select path="rating">
            <c:forEach begin="1" end="10" var="number">
                <form:option value="${number}" />
            </c:forEach>
        </form:select>
    </label>
    <br/><br/>

    <label>
    Publishers:
    <form:select itemLabel="name" itemValue="id"
                 path="publisher.id" items="${publishers}"/>
    </label><br/><br/>

    <label>
        Authors:
        <form:select itemLabel="firstName" itemValue="id"
                     path="authors" items="${authors}"/>
    </label><br/><br/>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
