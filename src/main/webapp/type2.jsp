<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>

<h1>Todo List</h1>

<h2>Items</h2>

<ul>
    <c:forEach var="item" items="${items}">
    <li>
        [<a href="delete?deleteid=${item.id}">X</a>]
        <c:out value="${item.info}"/>
    </li>
    </c:forEach>
</ul>

<h2>New</h2>

<form action="add" method="post">
    <input type="text" name="newitem"/> <input type="submit"/>
</form>

</body>
</html>
