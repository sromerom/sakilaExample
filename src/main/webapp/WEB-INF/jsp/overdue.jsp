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
        <th>Customer ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
        <c:forEach var="co" items="${customersOverdue}">
            <tr>
                <td>${co.customer_id}</td>
                <td>${co.first_name} ${co.last_name}</td>
                <td>${co.email}</td>
            </tr>
        </c:forEach>
</table>
</body>
</html>
