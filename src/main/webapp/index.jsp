<%@include file="head.jsp"%>
<%@include file="contentType.jsp" %>
<html>
<title>Welcome</title>
<body class="container">
<div class="card-panel">
    <div class="section center">
        <h1>MyPlaces Tracker</h1>
        <div class="divider"></div>
        <div class="row center">
            <p></p>
            <c:if test="${errorMsg != null}">
                <p>${errorMsg}</p>
            </c:if>
            <c:if test="${empty userName}">
                <a href="logIn">
                    <button type="button" class="btn waves-effect waves-blue darken-2">Log in</button>
                </a>
            </c:if>
        </div>
        <div class="row center">
            <c:if test="${!empty userName}">
                <h3>Welcome ${userName}</h3>
                <form action="viewTrips" class="" method="post">
                    <input type="hidden" class="" id="userName" name="userName" value="${userName}">
                    <button type="submit" name="submit" class="btn waves-effect waves-blue darken-2">View Trips
                    </button>
                </form>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>



