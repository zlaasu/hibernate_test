<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../include/head.jsp" />

<h1>Proposition list</h1>


<c:forEach items="${books}" var="book">
    <p><b>Id: </b>${book.id}</p>

    <p><b>Title: </b>${book.title}</p>
    <p><b>Rating: </b>${book.rating}</p>
    <p><b>Publisher: </b>${book.publisher.name}</p>
    <p><b>Author: </b>
        <c:forEach items="${book.authors}" var="author">
            ${author.firstName},
        </c:forEach>
    </p>

    <p><b>Actions</b>
        <a href="/proposition/edit/${book.id}">EDIT</a> |
        <a href="#" onclick="confirmDelete(${book.id}, '${book.title}')">DELETE</a> |
        <a href="/book/edit/${book.id}">MAKE BOOK</a>
    </p>

    <hr>
</c:forEach>

<script>
    function confirmDelete(id, title) {
        if (confirm("Do you want to delete a proposition '" + title + "'?")) {
            window.location.href = "/proposition/delete/" + id;
        }
    }
</script>

</body>
</html>
