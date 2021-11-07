<%--
  Created by IntelliJ IDEA.
  User: jk
  Date: 10/3/21
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="contentType.jsp" %>
<html>
<%@include file="head.jsp" %>
<body class="container">
<div class="card-panel">
<h1>Edit Note</h1>
<form action="editNote" class="" method="post">

    <input type="hidden" class="" id="noteId" name="noteId" value="${note.id}" >
    <input type="text" class="" id="noteName" name="noteName" aria-describedby="noteName" placeholder="${note.name}">
    <input type="text" class="" id="noteDescription" name="noteDescription" aria-describedby="noteDescription" placeholder="${note.description}">

  <button type="submit" name="submit" value="editNote" class="btn waves-effect waves-blue">Update</button>
  <button type="submit" name="submit" value="deleteNote" class="btn waves-effect waves-blue">Delete</button>
</form>
</div>
</body>
</html>
