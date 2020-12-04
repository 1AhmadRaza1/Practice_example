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
<form:form>

<div align="center"><a href="add-offer">Add offer</a></div>
<br>
<br>
<br>
<div align="center"><font color="blue"></font></div>

	<table align="center" style="width: 70%">
		<tr>
			<th align="center">Purchase Item Id</th><th align="center" width="200px">Purchase Id</th><th align="center" width="200px">Product Name</th><th align="center" width="200px">Quantity</th><th align="center" width="200px"> Action </th>
		</tr>
		<c:forEach var="purchaseItemMaster" items="${purchaseItemMasters}">
		<tr>
			<td width="200px" align="center">${purchaseItemMaster.purchase_item_master_id}</td>
			<td align="center" width="200px">${purchaseItemMaster.purchase_master_id}</td>
			<td align="center" width="200px">${purchaseItemMaster.product_name}</td>
			<td align="center" width="200px">${purchaseItemMaster.quantity}</td>
			<td align="center" width="200px"><a href="edit-purchase-product-item/${purchaseItemMaster.purchase_item_master_id}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="delete-purchase-product-item/${purchaseItemMaster.purchase_item_master_id}"> Delete </a>
			</td>
		</tr>
		</c:forEach>
	</table>
</form:form>
</body>
</html>