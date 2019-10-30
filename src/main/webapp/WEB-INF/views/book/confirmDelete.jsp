<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../include/head.jsp" />

<p>Are do you whand to delete book <b>${book.title}?</b></p>


<a href="/book/list">NIE!!!!</a>

<a href="/book/delete/${book.id}">TAK!!!!</a>

</body>
</html>
