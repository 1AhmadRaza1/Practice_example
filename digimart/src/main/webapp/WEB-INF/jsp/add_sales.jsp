<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<form:form modelAttribute="addsales" method="post" action="add-new-sales-detail">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Sales Detail </td>
				</tr>
				<tr>
					<td align="center">Customer name <font color="red">*</font></td><td align="center">
						<form:select path="sales_name" id="sales_name">
							<form:option value="-1">Select your name</form:option>
								<form:options items="${customers}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td align="center">Product name <font color="red">*</font></td><td align="center">
						<form:select path="product_name" id="product_name" multiple="multiple" >
							<form:option value="-1"> -- Select multiple product --</form:option>
							<form:options items="${products}" />
						</form:select></td>
				</tr>	
				<tr>
					<td align="center">Mobile number <font color="red">*</font></td><td align="center"><form:input path="mobile_number" id="mobile_number"/></td>
				</tr>
				<tr>
					<td align="center">Date <font color="red">*</font></td><td align="center"><input type="date" name="datetime" id="datetime" /></td>
				</tr>
				<tr>
					<td align="center">Total amount <font color="red">*</font></td><td align="center"><form:input path="total_ammount" id="total_ammount"/></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>
</body>
</html>