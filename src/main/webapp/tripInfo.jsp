<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>${tripInfo.getName()} Info</h1>
<h2>Destinations</h2>
<div class="">
    <form action="/tripInfo" class="" method="post">
        <table class="table">
            <thead>
            <th>City</th>
            <th>Placehoder</th>
            </thead>
            <tbody>
                <c:forEach var="destination" items="${destinationSet}">
                <tr>
                    <td>${destination.getCity()}</td>
                    <td>Placeholder}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
    <div class="">
        <h2>Travel Notes: </h2>
        <table id="" class="" >
            <tbody>
            <form action="forwardToEditNote" class="" method="post">
            <c:forEach var="note" items="${noteSet}">

                <tr>
                    <td>
                        <button type="submit" name="submit" class="">${note.name}</button>
                    </td>
                    <td>
                        <input type="hidden" class="" id="editTripID" name="editTripID" value="${tripInfo.getId()}" >
                    </td>

                </tr>
                <tr>
                    <td>${note.description}</td>
                </tr>

            </c:forEach>
            </form>
            </tbody>
        </table>
    </div>
</div>
<div>
<form action="forwardToAddNote" class="" method="post">
<input type="hidden" class="" id="tripID" name="tripID" value="${tripInfo.getId()}" >
<button type="submit" name="submit" class="">Add Travel Note</button>
</form>
</div>
</body>
</html>
