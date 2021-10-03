<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>View Trips</h1>
<div class="">

    <table class="table">
        <thead>
        <!--
        <tr>
            <th scope="">Trip Name</th>
        </tr>
        -->
        </thead>
        <tbody>
        <c:forEach var="trip" items="${trips}">
            <form action="tripInfo" class="" method="post">
            <tr>
                <td><input type="hidden" class="" id="tripID" name="tripID" value="${trip.getId()}" ></td>
                <td><button type="submit" name="submit" class="">View</button></td>
                <td>${trip.getName()}</td>
            </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <a href="addTrip.jsp">Add Trip</a>
</div>
</body>
</html>