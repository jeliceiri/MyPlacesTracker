<%--
  Created by IntelliJ IDEA.
  User: jk
  Date: 10/3/21
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Note</title>
</head>
<body>
<h1>Edit Note</h1>
<form action="editNote" class="" method="post">
  <div class="">
    <p>${note.getId()}</p>
    <input type="hidden" class="" id="noteId" name="noteId" value="${note.getId()}" >
    <input type="text" class="" id="noteName" name="noteName" aria-describedby="noteName" placeholder="${note.getName()}">
    <input type="text" class="" id="noteDescription" name="noteDescription" aria-describedby="noteDescription" placeholder="${note.getDescription()}">
  </div>
  <button type="submit" name="submit" value="editNote" class="">Update</button>
  <button type="submit" name="submit" value="deleteNote" class="">Delete</button>
</form>

</body>
</html>
