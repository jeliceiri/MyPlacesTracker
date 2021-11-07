<%@include file="contentType.jsp" %>
<html>
<jsp:include page="head.jsp" />
<c:set var="title" value="My Places Tracker"/>
<body class="container">
<div class="card-panel">
<c:choose>
    <c:when test="${empty userName}">
        <a href="logIn"><button type="button" class="btn waves-effect waves-blue">Log in</button></a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${userName}</h3>
        <form action="viewTrips" class="" method="post">
            <input type="hidden" class="" id="userName" name="userName" value="${userName}">
            <button type="submit" name="submit" class="btn waves-effect waves-blue">View Trips</button>
        </form>
    </c:otherwise>
</c:choose>
</div>
</body>
</html>



