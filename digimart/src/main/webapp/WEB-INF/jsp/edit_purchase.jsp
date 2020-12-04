<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Edit Purchase </title>
<link href="../css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
<br>
<br>
<br>
<form:form modelAttribute="editpurchase" method="POST" action="${pageContext.request.contextPath}/edit-new-purchase">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center">Update Purchase Detail </td>
				</tr>
				<form:hidden path="purchase_master_id" id="purchase_master_id"/>
				<tr>
					<td align="center">Supplier name <font color="red">*</font></td><td align="center">
						<form:select path="supplier_id" id="supplier_id">
							<form:option value="-1">Select Supplier name</form:option>
								<form:options items="${supliers}" />
						</form:select>
					</td>
				</tr>
				<tr><td colspan="2"><button id="addProduct">Add product></button></td></tr>
				<tr> 
					<td align="center">Product Name <font color="red">*</font></td><td align="center">
						<form:select path="product_name" id="product_name">
							<form:option value="-1">Select Product Name</form:option>
								<form:options items="${products}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td align="center">Date <font color="red">*</font></td><td align="center"><input type="date" name="purchase_date_time" id="purchase_date_time" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>

</body>
</html>