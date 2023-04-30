<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Book List</title>
<style>

.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}
.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}
a{
font-size:20px;
text-align:center;
text-decoration:none;
}

</style>
</head>
<body>
<%@page import="elibrary.*,java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Book List</h1>
<%List<BookInfo> list = BookDao.getAllBooks();
request.setAttribute("list",list);
%>
<table border="1" width="100%" class="styled-table">
<thead>
<tr>
<th>ID</th>
<th>NAME</th>
<th>QUANTITY</th>
</tr>
</thead>
<c:forEach items="${list}" var="b">
<tr><td>${b.getBid()}</td><td>${b.getBname()}</td><td>${b.getQuantity()}</td></tr>
</c:forEach>
<tr>
<td></td>
</tr>
</table>
<a href="IssueBook.html">IssueBook</a><br>
<a href="ReturnBook.html">ReturnBook</a><br>
<a href="ViewIssuedBook">View Issue Books</a>
</body>
</html>