<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head><title>SpringBoot</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

<table>
  <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Action</th>
  </tr>
   <c:forEach var = "list" items = "${lists}">
  <tr>
    <td>${list.id}</td>
    <td>${list.firstName}</td>
    <td>${list.lastName}</td>
    <td>
        <a href="/appusers/view/${list.id}">View</a>
        <a href="/appusers/delete/${list.id}">Delete</a>
        <a href="/appusers/edit/${list.id}">Edit</a>
    </td>
  </tr>
  </c:forEach>
</table>
<hr/>
<form method="post" action="/appusers/save">
<input type="hidden" name="id" value=""/>
  First name:<br>
  <input type="text" name="firstname"/>
  <br>
  Last name:<br>
  <input type="text" name="lastname" >
  <br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>
