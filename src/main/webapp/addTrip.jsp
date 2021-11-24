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
<body class="container" onload="">
<div class="card-panel">
    <h1>Add Trip</h1>
    <form action="addTrip" class="" method="post">
        <div class="input-field">
            <input type="hidden" class="" id="userId" name="userId" value="${userId}">
            <input type="text" class="validate" required="" aria-required="true" id="addTrip" name="addTrip" aria-describedby="addTrip" placeholder="Trip Name">
        </div>
        <button type="submit" name="submit" value="addTrip" class="btn waves-effect waves-blue">Add Trip</button>
        <span class="error">
    <c:forEach var="err" items="${errMsg}">
        <br/>
        <c:out value="${err}"/>
    </c:forEach>
    </span>
    </form>
</div>
</body>
</html>
