<%@ page import="net.rallyedu.todo.model.Item" %>
<%@ page import="net.rallyedu.todo.model.ItemList" %>
<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%
    ItemList itemList = new ItemList();

    String newItem = request.getParameter("newitem");
    if (newItem != null) {
        itemList.add(newItem);
        response.sendRedirect(request.getRequestURI());
        return;
    }

    String deleteId = request.getParameter("deleteid");
    if (deleteId != null) {
        try {
            itemList.delete(Integer.parseInt(deleteId));
            response.sendRedirect(request.getRequestURI());
            return;
        } catch (NumberFormatException e) {
            throw new ServletException("Bad deleteid value submitted.", e);
        }
    }
%>

<html>
<head>
    <title>Todo List</title>
</head>
<body>

<h1>Todo List</h1>

<h2>Items</h2>

<ul>
    <%
        for (Item item : itemList.get()) {
    %>
    <li>
        [<a href="type1.jsp?deleteid=<%= item.getId() %>">X</a>]
        <%= StringEscapeUtils.escapeHtml(item.getInfo()) %>
    </li>
    <%
        }
    %>
</ul>

<h2>New</h2>

<form action="type1.jsp" method="post">
    <input type="text" name="newitem"/> <input type="submit"/>
</form>

</body>
</html>
