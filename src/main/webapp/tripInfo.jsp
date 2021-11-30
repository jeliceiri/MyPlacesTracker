<%@include file="contentType.jsp" %>


<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#noteTable').DataTable();
    });
    $(document).ready(function () {
        $('#tripInfoTable').DataTable();
    });
</script>

<html>
<%@include file="head.jsp" %>
<body class="container">
<h1>Trip Info: ${tripInfo.name}</h1>
<div class="card-panel">
<h2>Destinations</h2>

    <form action="tripInfo" class="" method="post">
        <table class="table" id="tripInfoTable">
            <thead>
            <th>City</th>
            <th>State</th>
            <th>Zip Code</th>
            <th>County Fips Code</th>
            <th>Nearby Hospital ICU Capacity*</th>
            <th>County Covid Risk Level <br/>Low, Med, High, Very High, or Severe</th>
            </thead>
            <tbody>
            <c:forEach var="destination" items="${destinationSet}">
                <tr>
                    <td>${destination.city}</td>
                    <td>${destination.state}</td>
                    <td>${destination.zipCode}</td>
                    <td>${destination.countyFipsCode}</td>
                    <td>${destination.countyHospitalCapacity}</td>
                    <td>${destination.risk}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>* Displays the Percent Occupied or N/A (data is not available)</p>
        <c:if test="${not empty destinationSet}">
            <input type="hidden" class="" id="tripIDUpdate" name="tripID" value="${tripInfo.id}">
            <button type="submit" value="Refresh" name="submit" class="btn waves-effect waves-blue">Refresh</button>
        </c:if>
        <c:if test="${not empty refreshed}">
            <p><i>${refreshed}</i></p>
        </c:if>

    </form>
</div>
    <div class="card-panel">
        <h2>Travel Notes </h2>
        <table class="table" id="noteTable">
            <thead>
            <th>Note Name</th>
            <th>Note Description</th>
            <th></th>
            </thead>
            <tbody>
            <c:forEach var="note" items="${noteSet}">
                <form action="editNoteForm" class="" method="post">
                    <tr>
                        <td>${note.name}</td>
                        <td>${note.description}</td>
                        <td><input type="hidden" id="noteId" name="noteId" value="${note.id}"></td>
                        <td>
                            <button type="submit" name="submit" class="btn waves-effect waves-blue">Edit</button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>
    </div>

<div class="card-panel">
<form action="addDestinationForm" class="" method="post">
    <input type="hidden" class="" id="tripIDDestination" name="tripID" value="${tripInfo.id}">
    <button type="submit" name="submit" class="btn waves-effect waves-blue">Add Destination</button>
</form>

<form action="addNoteForm" class="" method="post">
    <input type="hidden" class="" id="tripID" name="tripID" value="${tripInfo.id}">
    <button type="submit" name="submit" class="btn waves-effect waves-blue">Add Travel Note</button>
</form>

<form action="viewTrips" class="" method="post">
    <input type="hidden" class="" id="userName" name="userName" value="${userName}">
    <button type="submit" name="submit" class="btn waves-effect waves-blue">View Trips</button>
</form>
</div>

</body>
</html>
