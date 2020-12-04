<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<br>
<marquee>List Of Student</marquee>
<br>
<br>
<br>
	<table align="center" border="1">
		<tr>
			<th>Sr. No. </th><th>Student Name</th><th>Gender</th><th>Date Of Birth</th><th>Email</th><th>Password</th><th>Mobile NO</th><th> Action  </th>
		</tr>
		<c:forEach var="student" items="${student}">
			<tr>
				<td>${student.stud_reg_id}</td>
				<td>${student.stud_name}</td>
				<td>${student.gender}</td>
				<td>${student.dob}</td>
				<td>${student.email}</td>
				<td>${student.password}</td>
				<td>${student.mobileno}</td>
				<td><a href="${pageContext.request.contextPath}/editstudent/${student.stud_reg_id}.html"> Edit </a>
				<a href="${pageContext.request.contextPath}/deletestudent/${student.stud_reg_id}.html"> Delete </a></td>
			</tr>
		</c:forEach>		
	</table>
	
	
	<br/>
	<br/>
	<br/>
	<div align="center"><a href="${pageContext.request.contextPath}/registration.html"> New Student </a></div>
	<br/>
	<br/>
	<br/>
	<div align="center"><a href="${pageContext.request.contextPath}/.html">Go Home </a></div>
</body>
</html>