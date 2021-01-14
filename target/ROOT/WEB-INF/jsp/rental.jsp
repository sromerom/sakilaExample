<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rental DVD</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<h1>Rent a film:</h1>
<c:choose>
    <c:when test="${empty status}">
        <form action="${pageContext.request.contextPath}/rental" method="POST">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="films">Films</label>
                </div>
                <select class="custom-select" id="films" name="films">
                    <option selected>Choose...</option>
                    <c:forEach var="f" items="${films}">
                        <option value="${f.film_id}">
                                ${f.title}
                        </option>
                    </c:forEach>
                </select>
            </div>


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="customers">Customers</label>
                </div>
                <select class="custom-select" id="customers" name="customers">
                    <option selected>Choose...</option>
                    <c:forEach var="c" items="${customers}">
                        <option value="${c.customer_id}">
                                ${c.first_name} ${c.last_name}
                        </option>
                    </c:forEach>
                </select>
            </div>


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="staffs">Staffs</label>
                </div>
                <select name="staffs" id="staffs">
                    <option selected>Choose...</option>
                    <c:forEach var="s" items="${staffs}">
                        <option value="${s.staff_id}">
                                ${s.first_name} ${s.last_name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Rent Film</button>
        </form>
    </c:when>
    <c:otherwise>
        <c:if test="${status == -1}"><h2>DVD rent error.</h2></c:if>
        <c:if test="${status == 0}"><h2>DVD rental successful.</h2></c:if>
        <c:if test="${status == 1}"><h2>Inventory not available, try to choose another staff.</h2></c:if>
    </c:otherwise>
</c:choose>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
</body>
</html>
