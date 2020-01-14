<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="abc.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Data</title>
</head>
<body>
<%
StudentModel m = (StudentModel) request.getAttribute("student");
%>


<center><h1>Update Data</h1></center>
<center>
<form action="UpdateBack" method="post">
<label>Student USN</label>
<input type="text" name="usn" value="<%= m.getUsn() %>"  ><br>
<label>Student NAME</label>
<input type="text" name="name" value="<%= m.getName() %>" ><br>
<label>Student DEPT</label>
<input type="text" name="dept" value="<%= m.getDept() %>" ><br>
<label>Student COLLEGE</label>
<input type="text" name="colg" value="<%= m.getColg() %>" ><br>
<input type="submit" value="Update">
</form>
</center>
</body>
</html>