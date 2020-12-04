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
<body id="b1">

<c:forEach var="msg" items="${msg}">
<div align="center"><font color="red">${msg}</font></div>
<br>
</c:forEach>
<br>
<form:form method="post" modelAttribute="forgetByEmail" action="check-emailid-exist">
	<table align="center">
				
		<tr>
			<td colspan="2" id="ltitle" align="center"> Forgot Password </td>
		</tr>
		<tr>
			<td align="center">Email Id<font color="red">*</font></td><td align="center"><form:input path="admin_email" id="admin_email" /></td>
		</tr>
				
		<tr>
			<td align="center" colspan="2"><input type="submit" value="Next" id="save_admin"></td>
		</tr>
	</table>
</form:form>

</body>
</html>