<%@include file="contentType.jsp" %>
<%@include file="head.jsp" %>
<c:set var="title" value="Trips"/>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#tripsTable').DataTable();
    });
</script>

<html>
<body class="container">
<div class="card-panel">
<h1>View Trips</h1>


    <table class="table" id="tripsTable">
        <thead>
        <th>Trip Name</th>
        </thead>
        <tbody>
        <c:forEach var="trip" items="${trips}">
            <form action="tripInfo" class="" method="post">
                <tr>
                    <td>${trip.name}</td>
                    <td><input type="hidden" class="" id="tripID" name="tripID" value="${trip.id}"></td>
                    <td>
                        <button type="submit" name="submit" class="btn waves-effect waves-blue">View</button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>

</div>
<div class="card-panel">
    <a href="addTrip.jsp"><button type="button" class="btn waves-effect waves-blue">Add Trip</button></a>
</div>
</body>
</html>