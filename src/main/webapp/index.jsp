<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:choose>
    <c:when test="${empty userName}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
        <a href = "viewTrips">View Trips</a>

        <form action="viewTrips" class="" method="post">
                <input type="hidden" class="" id="userName" name="userName" value="${userName}" >
                <button type="submit" name="submit" class="">View Trips</button>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>



