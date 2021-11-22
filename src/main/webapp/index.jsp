<%@include file="contentType.jsp" %>
<html>
<jsp:include page="head.jsp"/>
<body class="container">
<div class="card-panel">
    <h1>My Places Tracker</h1>
    <c:if test="${errorMsg != null}">
            <p>${errorMsg}</p>
    </c:if>
    <c:if test="${empty userName}">
            <a href="logIn">
                <button type="button" class="btn waves-effect waves-blue darken-2">Log in</button>
            </a>
    </c:if>
    <c:if test="${!empty userName}">
            <h3>Welcome ${userName}</h3>
            <form action="viewTrips" class="" method="post">
                <input type="hidden" class="" id="userName" name="userName" value="${userName}">
                <button type="submit" name="submit" class="btn waves-effect ">View Trips</button>
            </form>
    </c:if>
</div>
</body>
</html>



