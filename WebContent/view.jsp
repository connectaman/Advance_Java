<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,abc.StudentModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Database</title>
  <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
 <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
</head>
<body>
<%
List<StudentModel> list = (List<StudentModel>)request.getAttribute("student");
%>



<center><h1>Student Database</h1></center>
<center>
<form action="ViewStudent" method="POST">
<input type="text" name="search" placeholder="Search Student">
<input type="submit" value="search">
</form>

</center>


<center>
<table id="mytable"  class="display">
<thead>
<tr>
<th>USN</th>
<th>NAME</th>
<th>DEPT</th>
<th>COLLEGE</th>
<th>UPDATE</th>
<th>DELETE</th>
</tr>
</thead>
<tbody>
<%
for(StudentModel data:list){
%>
<tr>
<td><%= data.getUsn() %></td>
<td><%= data.getName() %></td>
<td><%= data.getDept() %></td>
<td><%= data.getColg() %></td>
<td><a href="UpdateStudent?id=<%= data.getUsn() %>">Update</a></td>
<td><a href="DeleteStudent?id=<%= data.getUsn() %>">Delete</a></td>
</tr>
<%} %>
</tbody>
</table>
</center>
<script>
$(function(){
    $("#mytable").dataTable();
  })
</script>
</body>

</html>