<%--
  Created by IntelliJ IDEA.
  User: jk
  Date: 9/26/21
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="contentType.jsp" %>

<html>
<%@include file="head.jsp" %>
<c:set var="title" value="Add Trip"/>
<body class="container">
<div class="card-panel">
<form action="addTrip" class="" method="post">
    <div class="">
        <input type="hidden" class="" id="userId" name="userId" value="${userId}" >
        <input type="text" class="" id="addTrip" name="addTrip" aria-describedby="addTrip" placeholder="Trip Name">
    </div>
    <button type="submit" name="submit" value="addTrip" class="btn waves-effect waves-blue">Add Trip</button>
</form>
</div>
</body>
</html>
