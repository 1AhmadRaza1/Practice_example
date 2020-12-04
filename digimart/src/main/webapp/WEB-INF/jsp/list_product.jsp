<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="padding-top: 40px">
<br>
<br>
<div> <a href="add-product">Add product</a> </div>
<br>
<br>
<div align="center"><font color="blue"><a href="http://localhost:8080/digimart/"><h3> Home </h3></a></font><font color="blue"><h3> List of Product </h3></font><font color="blue"><a href="add-product"><h3> Add product</h3></a></font></div>
<div style="padding-top: 50px"></div>
<table style="align-self: center; border:1px solid black; width: 100%" >
		<tr>
			<th width="5xp">Product id</th><th>Product name</th><th>Category name</th><th>Sub Category name</th><th>Product description</th><th>Price</th><th>Expiry date</th><th>Manufacture date</th><th>Manufacturer Company name</th><th>Discount type</th><th>Discount amount</th><th align="right">Product photo</th><th align="center"> Action </th>
		</tr>
		<c:forEach var="produclist" items="${listproduct}">
		<tr>
			<td align="center">${produclist.product_master_id}</td>
			<td width="20px" align="center">${produclist.product_name}</td>
			<td width="150px" align="center">${produclist.cattegory_name}</td>
			<td width="150px" align="center">${produclist.sub_cattegory_name}</td>
			<td width="150px" align="center">${produclist.product_description}</td>
			<td width="10px" align="center">${produclist.product_prise}</td>
			<td width="100px" align="center">${produclist.product_expiry_date}</td>
			<td width="100px" align="center">${produclist.product_manufacture_date}</td>
			<td width="200px" align="center">${produclist.product_company_name}</td>
			<td width="20px" align="center">${produclist.product_discount_type}</td>
			<td width="20px" align="center">${produclist.product_discount}</td>
			<td align="center"><img src="data:image/jpg;base64,${produclist.product_photo}" height="100px" width="100px" align="right"></td>
			<td align="center" width="100px"><a href="edit-product/${produclist.product_master_id}"> Edit </a>&nbsp;&nbsp;  &nbsp;&nbsp;<a href="delete-prduct-by/${produclist.product_master_id}"> Delete </a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>