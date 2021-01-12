<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rental DVD</title>
</head>
<body>
<h1>Rent a film:</h1>
<c:if test="${empty status}">
    <form action="${pageContext.request.contextPath}/rental" method="POST">
        <label for="films">Films</label>
        <select name="films" id="films">
            <c:forEach var="f" items="${films}">
                <option value="${f.film_id}">
                        ${f.title}
                </option>
            </c:forEach>
        </select>

        <label for="customers">Customers</label>
        <select name="customers" id="customers">
            <c:forEach var="c" items="${customers}">
                <option value="${c.customer_id}">
                        ${c.first_name} ${c.last_name}
                </option>
            </c:forEach>
        </select>
        <label for="staffs">Staffs</label>
        <select name="staffs" id="staffs">
            <c:forEach var="s" items="${staffs}">
                <option value="${s.staff_id}">
                        ${s.first_name} ${s.last_name}
                </option>
            </c:forEach>
        </select>
        <button type="submit">Rent</button>
    </form>
</c:if>
<c:if test="${not empty status}">
    <c:if test="${not status}"><h2>DVD rent error.</h2></c:if>
    <c:if test="${status}"><h2>DVD rental successful.</h2></c:if>
</c:if>
</body>
</html>
