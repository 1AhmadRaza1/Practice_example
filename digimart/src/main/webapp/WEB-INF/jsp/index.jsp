<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page </title>
<link href="css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
<div align="center"><font color="red">${msg}</font></div>
<form:form method="post" modelAttribute="adminLogin" action="admin-detail">
	
	<br>
	<table align="center">
				
				<tr>
					<td colspan="2" id="ltitle" align="center"> Admin Login </td>
				</tr>
				<tr>
					<td align="center">Email Id<font color="red">*</font></td><td align="center"><form:input path="admin_email" id="admin_email" /></td>
				</tr>
				<tr>
					<td align="center">Password<font color="red">*</font></td><td align="center"><form:input path="admin_password" id="admin_password" /></td>
				</tr>
				
				<tr>
					<td align="right"><a href="forgot-by-email">Forgot Password</a></td><td align="center"><a href="new-admin-profile">New Admin</a></td>
				</tr>
				
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
				</table>
</form:form>
</body>
</html>