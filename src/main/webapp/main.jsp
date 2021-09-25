<%--
  Created by IntelliJ IDEA.
  User: jk
  Date: 9/25/21
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Places Tracker</title>
</head>

<body>
<%--Put results in a bootstrap rowusing JSTL--%>
<div class="">
  <h2>My Trips: </h2>
  <table class="table">
    <thead>
    <tr>
      <th scope="">Trip Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="trip" items="${trips}">
      <tr>
        <td>${trip.getName()}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
