<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<c:set var="title" value="Trips" />

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#tripsTable').DataTable();
    } );
</script>

<html>
<body>
<h1>View Trips</h1>
<div class="">

    <table class="table" id="tripsTable">
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
                <td><input type="hidden" class="" id="tripID" name="tripID" value="${trip.id}" ></td>
                <td><button type="submit" name="submit" class="">View</button></td>
                <td>${trip.name}</td>
            </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <p>${userId}</p>
    <a href="addTrip.jsp">Add Trip</a>
</div>
</body>
</html>