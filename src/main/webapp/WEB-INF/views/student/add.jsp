<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../include/head.jsp" />

<h1>Add student</h1>

<form:form method="POST" modelAttribute="student">
    <label>
        First Name:
        <form:input path="firstName"/>
    </label><br/><br/>

    <label>
        Last Name:
        <form:input path="lastName"/>
    </label><br/><br/>

    <label>
        Gender:<br/>
        Male: <form:radiobutton path="gender" value="M"/>
        Female: <form:radiobutton path="gender" value="F"/>
    </label><br/><br/>

    <label>
        Country:
        <form:select path="country" items="${countries}"/>
    </label><br/><br/>

    <label>
        Note:
        <form:textarea path="notes"/>
    </label><br/><br/>

    <label>
        Mailing List:
        <form:checkbox path="mailingList"/>
    </label><br/><br/>

    <label>
        Skills:
        <form:select path="programmingSkills" items="${programmingSkills}"/>
    </label><br/><br/>

    <label>
        Hobbies:
        <form:checkboxes path="hobbies" items="${hobbies}"/>
    </label><br/><br/>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
