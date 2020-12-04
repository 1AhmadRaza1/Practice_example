<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>Full Name</th>
			<th>Gender</th>
			<th>Date Of Birth</th>
			<th>Email</th>
			<th>Mobile No.</th>
		</tr>
		<tr><td>${student.stud_name}</td>
			<td>${student.gender}</td>
			<td>${student.dob}</td>
			<td>${student.email}</td>
			<td>${student.mobileno}</td>
		</tr>
	</table>
</body>
</html>