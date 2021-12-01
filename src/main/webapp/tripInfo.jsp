<%@include file="head.jsp" %>
<%@include file="contentType.jsp" %>
<html>
<title>Trip Info</title>
<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#destinationTable').DataTable();
    });
</script>
<body class="container">
<div class="card-panel">
    <div class="section center">
        <h1>${tripInfo.name}</h1>
        <div class="divider"></div>
        <h2>Destinations</h2>
        <form action="tripInfo" class="" method="post">
            <table id="destinationTable">
                <thead>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>County Fips Code</th>
                <th>Nearby Hospital ICU Capacity Used*</th>
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
                <button type="submit" value="Refresh" name="submit" class="btn-small waves-effect waves-blue">Refresh
                </button>
            </c:if>
            <c:if test="${not empty refreshed}">
                <p><i>${refreshed}</i></p>
            </c:if>
        </form>
    </div>
    <div class="center">
        <h2>Travel Notes </h2>
        <table>
            <thead>
            <th>Note Name</th>
            <th>Note Description</th>
            <th></th>
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
                            <button type="submit" name="submit" class="btn-small waves-effect waves-blue">Edit</button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row center">
        <p></p>
        <form action="addDestinationForm" class="row" method="post">
            <input type="hidden" class="" id="tripIDDestination" name="tripID" value="${tripInfo.id}">
            <button type="submit" name="submit" class="btn waves-effect waves-blue">Add Destination</button>
        </form>

        <form action="addNoteForm" class="row" method="post">
            <input type="hidden" class="" id="tripID" name="tripID" value="${tripInfo.id}">
            <button type="submit" name="submit" class="btn waves-effect waves-blue">Add Travel Note</button>
        </form>

        <form action="viewTrips" class="row" method="post">
            <input type="hidden" class="" id="userName" name="userName" value="${userName}">
            <button type="submit" name="submit" class="btn waves-effect waves-blue">View Trips</button>
        </form>
    </div>
</div>
</body>
</html>