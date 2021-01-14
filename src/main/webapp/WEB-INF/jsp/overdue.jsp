<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Overdue Customers</title>
</head>
<body>
<h1>Overdue Customers</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Film</th>
        <th>Theorical Return Date</th>
    </tr>
        <c:forEach var="co" items="${customersOverdue}">
            <tr>
                <td>${co.name}</td>
                <td>${co.phone}</td>
                <td>${co.title}</td>
                <td>${co.theorical_return_date}</td>
            </tr>
        </c:forEach>
</table>
</body>
</html>
