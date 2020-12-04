<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer detail </title>
<link href="css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">

<div align="center">${msg}</div>
<br>
<br>
<br>
<form:form modelAttribute="addsupplier" method="post" action="add-new-supplier">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Add Supplier Detail </td>
				</tr>
				<tr>
					<td align="center">Supplier Name <font color="red">*</font></td><td align="center"><form:input path="suplier_name" id="suplier_name"/></td>
				</tr>	
				<tr>
					<td align="center">Email <font color="red">*</font></td><td align="center"><form:input path="suplier_email" id="suplier_email"/></td>
				</tr>
				<tr>
					<td align="center">Mobile Number <font color="red">*</font></td><td align="center"><form:input path="suplier_mobileno" id="suplier_mobileno"/></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save"> </td><td align="center"><input type="button" value="Cancel" id="cancelsup"></td>
				</tr>
			</table>
</form:form>

</body>
</html>