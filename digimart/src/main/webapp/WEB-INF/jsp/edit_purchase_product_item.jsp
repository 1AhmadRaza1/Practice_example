<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Update |Purchase Item Product Page </title>
<link href="../css/style_tag.css" rel="stylesheet">
</head>
<body>

<br>
<br>
<br>
<form:form modelAttribute="purchaseItemMaster" method="POST" action="${pageContext.request.contextPath}/edit-new-purchase-product-item">
	<table align="center">
		<tr>
			<td colspan="2" align="center" id="ltitle">Edit Purchase Item Product </td>
		</tr>
		<form:hidden path="purchase_item_master_id" id="purchase_item_master_id"/>
		<tr>
			<td align="center">Product Name<font color="red">*</font></td>
			<td><form:select path="product_master_id" id="product_master_id" >
					<form:option value="-1"> -- Select product Name -- </form:option>
					<form:options items="${productName}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td align="center">Quantity<font color="red">*</font></td><td><form:input path="quantity" id="quantity" /></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
		</tr>
	</table>
</form:form>
</body>
</html>