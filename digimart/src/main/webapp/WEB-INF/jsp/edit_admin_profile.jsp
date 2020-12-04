<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style_tag.css">
</head>
<body id="changeprofile">

	
<form:form modelAttribute="editprofile" method="POST" action="${pageContext.request.contextPath}/edit-admin-profile">
	<table align="center">
				
		<tr>
			<td colspan="2" id="ltitle" align="center"> Edit Admin Profile </td>
		</tr>
		<form:hidden path="admin_id" id="admin_id" />
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
					<td align="center"><input type="submit" value="Update" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
	</table>
</form:form>
	

</body>
</html>