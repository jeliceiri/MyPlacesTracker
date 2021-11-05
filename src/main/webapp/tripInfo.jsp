<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<c:set var="title" value="Trip Info" />

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#noteTable').DataTable();
        } );
</script>

<html>
<body>
<h1>${tripInfo.getName()}</h1>
<h2>Destinations</h2>
<div class="">
    <form action="tripInfo" class="" method="post">
        <table class="table" id="">
            <thead>
            <th>City</th>
            <th>Placehoder</th>
            </thead>
            <tbody>
                <c:forEach var="destination" items="${destinationSet}">
                <tr>
                    <td>${destination.city}</td>
                    <td>${destination.state}</td>
                    <td>${destination.countyFipsCode}</td>
                    <td>${destination.countyHospitalCapacity}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
    <div class="">
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
                        <td>${note.getName()}</td>
                        <td>${note.getDescription()}</td>
                        <td><input type="hidden" id="noteId" name="noteId" value="${note.id}"></td>
                        <td><button type="submit" name="submit" class="">Edit</button></td>
                    </tr>
                </form>
                </c:forEach>
                </tbody>
            </table>

    </div>
</div>


<div>
<form action="addNoteForm" class="" method="post">
<input type="hidden" class="" id="tripID" name="tripID" value="${tripInfo.id}" >
<button type="submit" name="submit" class="">Add Travel Note</button>
</form>
</div>

<form action="viewTrips" class="" method="post">
    <input type="hidden" class="" id="userName" name="userName" value="${userName}" >
    <button type="submit" name="submit" class="">View Trips</button>
</form>


</body>
</html>
