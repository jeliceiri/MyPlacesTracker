<%--
  Created by IntelliJ IDEA.
  User: jk
  Date: 9/26/21
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Destination</title>
</head>
<body>
<p>${trip.id}</p>
<h1>Add Destination</h1>
<form action="addDestination" class="" method="post">
  <div class="">
    <input type="hidden" class="" id="tripID" name="tripID" value="${trip.id}" >
    <input type="text" class="" id="destinationCity" name="destinationCity" aria-describedby="destinationCity" placeholder="City">
    <input type="text" class="" id="destinationState" name="destinationState" aria-describedby="destinationState" placeholder="State (Two-Digit Code)">
  </div>
  <button type="submit" name="submit" value="addDestination" class="">Add Destination</button>
</form>

</body>
</html>
