<%@include file="head.jsp" %>
<%@include file="contentType.jsp" %>
<html>
<title>My Trips</title>
<body class="container">
<div class="card-panel">
    <div class="section center">
        <h1>My Trips</h1>
        <table class="table" id="tripsTable">
            <thead>
            <th>Trip Name</th>
            <th></th>
            <th></th>
            </thead>
            <tbody>
            <c:forEach var="trip" items="${trips}">
                <form action="tripInfo" class="" method="post">
                    <tr>
                        <td>${trip.name}</td>
                        <td><input type="hidden" class="" id="tripID" name="tripID" value="${trip.id}"></td>
                        <td>
                            <button type="submit" name="submit" class="btn-small waves-effect waves-blue">View</button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div class="row center">
        <a href="addTrip.jsp">
            <button type="button" class="btn waves-effect waves-blue">Add Trip</button>
        </a>
    </div>
</div>
</body>
</html>