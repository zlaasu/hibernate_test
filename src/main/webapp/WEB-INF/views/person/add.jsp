<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../include/head.jsp" />

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
