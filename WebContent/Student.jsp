<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<%
String error = (String) request.getAttribute("status");
if(error!=null){
%>
<script>alert("<%= error  %>")</script>
<%} %>



<center><h1>Add Student</h1></center>
<form action="AddStudent" method="POST">
<lable>Enter Student Usn : </lable>
<input type="text" name="usn" required><br>
<lable>Enter Student Name : </lable>
<input type="text" name="name" required><br>
<lable>Enter Student Dept : </lable>
<input type="text" name="dept" required><br>
<lable>Enter Student College : </lable>
<input type="text" name="colg" required><br>
<input type="submit" value="Add">
</form>
</body>
</html>