<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style_tag.css" rel="stylesheet">
</head>
<body id="">
<c:forEach var="existemail" items="${existEmail}">
<div align="center"><h3>Welcome : ${existemail.admin_email}</h3></div>


<form:form method="post" modelAttribute="forgotPassword" action="forgot-password">
	<form:hidden path="admin_email" value="${existemail.admin_email}" />
	<table align="center">
				
		<tr>
			<td colspan="2" id="ltitle" align="center"> Forgot Password </td>
		</tr>
		<tr>
			<td align="center">New Password<font color="red">*</font></td><td align="center"><form:input path="admin_password" id="admin_password" /></td>
		</tr>			
		<tr>
			<td align="center" colspan="2"><input type="submit" value="Save" id="save_admin"> </td>
		</tr>
	</table>

</form:form>
</c:forEach>
</body>
</html>