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
<form:form modelAttribute="addcustomerdetail" method="post" action="add-new-customer-detail">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Customer Detail </td>
				</tr>
				<tr>
					<td align="center">Customer Name <font color="red">*</font></td><td align="center"><form:input path="customer_name" id="customer_name"/></td>
				</tr>
				<tr>
					<td align="center">Gender<font color="red">*</font></td><td align="center"><form:radiobutton path="gender" id="gender" value="male" />Male&nbsp;&nbsp;&nbsp;<form:radiobutton path="gender" id="gender" value="female" />Female</td>
				</tr>
				<tr>
					<td align="center">Date <font color="red">*</font></td><td align="center"><input type="date" name="dob" id="dob" /></td>
				</tr>	
				<tr>
					<td align="center">Email <font color="red">*</font></td><td align="center"><form:input path="email" id="email"/></td>
				</tr>
				<tr>
					<td align="center">Mobile Number <font color="red">*</font></td><td align="center"><form:input path="mobile_number" id="mobile_number"/></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>

</body>
</html>