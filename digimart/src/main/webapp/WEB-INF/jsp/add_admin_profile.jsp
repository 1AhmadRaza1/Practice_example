<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Add Profile Page </title>
<link href="css/style_tag.css" rel="stylesheet">
</head>
<body>

<form:form modelAttribute="addAdmin" method="post" action="save-admin-profile">
	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Add Admin Profile </td>
				</tr>
				<tr>
					<td align="center">Full Name<font color="red">*</font></td><td align="center"><form:input path="admin_name" id="admin_name"/></td>
				</tr>
				<tr>
					<td align="center">Mobile No.<font color="red">*</font></td><td align="center"><form:input path="admin_mobile" id="admin_mobile"/></td>
				</tr>
				<tr>
					<td align="center">Email Id<font color="red">*</font></td><td align="center"><form:input path="admin_email" id="admin_email" /></td>
				</tr>
				<tr>
					<td align="center">Password<font color="red">*</font></td><td align="center"><form:input path="admin_password" id="admin_password" /></td>
				</tr>
				
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>
</body>
</html>