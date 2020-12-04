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
<marquee>Student Detail Form </marquee>
	<form:form method="post" modelAttribute="student" action="${pageContext.request.contextPath}/registration.html">
		<table align="center">
			<tr>
				<td align="right">Full Name : </td>
				<td><form:input path="stud_name"/></td>
			</tr>
			<tr>
				<td align="right">Gender : </td>
				<td><form:radiobuttons items="${gender}" path="gender" /></td>
			</tr>
			<tr>
				<td align="right">Date Of Birth : </td>
				<td><form:input path="dob" /></td>
			</tr>
			<tr>
				<td align="right">Email : </td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td align="right">Password : </td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td align="right">Mobile No. : </td>
				<td><form:input path="mobileno"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>