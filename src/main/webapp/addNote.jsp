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
<body class="container">
<div class="card-panel">
    <h1>Add Note</h1>
<form action="addNote" class="" method="post">
    <input type="hidden" class="" id="tripID" name="tripID" value="${trip.id}" >
    <input type="text" class="" class="validate" required="" aria-required="true" id="noteName" name="noteName" aria-describedby="noteName" placeholder="Note Name">
    <input type="text" class="" class="validate" required="" aria-required="true" id="noteDescription" name="noteDescription" aria-describedby="noteDescription" placeholder="Description">
  <button type="submit" name="submit" value="addNote" class="btn waves-effect waves-blue">Add Note</button>
</form>
</div>
</body>
</html>
