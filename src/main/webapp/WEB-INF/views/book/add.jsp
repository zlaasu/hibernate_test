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
    <style>
        .error {
            background-color: red;
            -webkit-animation-name: example; /* Safari 4.0 - 8.0 */
            -webkit-animation-duration: 4s; /* Safari 4.0 - 8.0 */
            animation-name: example;
            animation-duration: 4s;
        }

        /* Safari 4.0 - 8.0 */
        @-webkit-keyframes example {
            from {
                background-color: red;
            }
            to {
                background-color: yellow;
            }
        }

        /* Standard syntax */
        @keyframes example {
            from {
                background-color: red;
            }
            to {
                background-color: yellow;
            }
        }
    </style>
</head>
<body>

<h1>Add book</h1>

<form:form method="POST" modelAttribute="book">

    <form:hidden path="id"/>

    <label>
        Title:
        <form:input path="title"/>
        <form:errors path="title" element="div" cssClass="error"/>
    </label>
    <br/><br/>

    <label>
        Description:
        <form:textarea path="description"/>
        <form:errors path="description" element="div" cssClass="error"/>
    </label>
    <br/><br/>

    <label>
        Pages:
        <form:input path="pages"/>
        <form:errors path="pages" element="div" cssClass="error"/>
    </label>
    <br/><br/>

    <label>
        Rating:
        <form:select path="rating">
            <c:forEach begin="1" end="10" var="number">
                <form:option value="${number}"/>
            </c:forEach>
        </form:select>
        <form:errors path="rating" element="div" cssClass="error"/>
    </label>
    <br/><br/>

    <label>
        Publishers:
        <form:select itemLabel="name" itemValue="id"
                     path="publisher.id" items="${publishers}"/>
        <form:errors path="publisher" element="div" cssClass="error"/>
    </label><br/><br/>

    <label>
        Authors:
        <form:select itemLabel="firstName" itemValue="id"
                     path="authors" items="${authors}"/>
        <form:errors path="authors" element="div" cssClass="error"/>
    </label><br/><br/>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
