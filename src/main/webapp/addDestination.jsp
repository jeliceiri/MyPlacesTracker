<%--
  Created by IntelliJ IDEA.
  User: jk
  Date: 9/26/21
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="contentType.jsp" %>

<%@include file="head.jsp" %>

<html>
<body class="container">
<div class="card-panel">
    <h1>Add Destination</h1>
    <form action="addDestination" class="" method="post">
        <div class="input-field">
            <input type="hidden" class="" id="tripID" name="tripID" value="${trip.id}">
            <input type="text" class="validate" required="" aria-required="true" id="destinationCity"
                   name="destinationCity" aria-describedby="destinationCity" placeholder="City">
        </div>
        <div class="input-field">
            <input type="text" class="" id="destinationState" name="destinationState" class="validate" required=""
                   aria-required="true"
                   aria-describedby="destinationState" placeholder="State (Two-Digit Code)">
        </div>
        <button type="submit" name="submit" value="addDestination" class="btn waves-effect waves-blue">Add Destination
        </button>
        <span class="error">
        <c:forEach var="err" items="${errMsg}">
            <c:out value="${err}"/>
            <br/>
        </c:forEach>
        </span>
    </form>
</div>
</body>
</html>
