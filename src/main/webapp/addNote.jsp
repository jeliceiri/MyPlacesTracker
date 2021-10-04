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
  <title>Add Note</title>
</head>
<body>
<h1>Add Note</h1>
<form action="addNote" class="" method="post">
  <div class="">
    <input type="hidden" class="" id="tripID" name="tripID" value="${trip.getId()}" >
    <input type="text" class="" id="noteName" name="noteName" aria-describedby="noteName" placeholder="Note Name">
    <input type="text" class="" id="noteDescription" name="noteDescription" aria-describedby="noteDescription" placeholder="Description">
  </div>
  <button type="submit" name="submit" value="addNote" class="">Add Note</button>
</form>

</body>
</html>
