<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard Page </title>
</head>
<body>

<div><h1>Dashboard Page</h1></div>
<c:forEach var="loginAdmin" items="${adminEmail}">
<div align="center"><h3>Welcome: ${loginAdmin.admin_name}</h3></div>
<br>
<br>
<table style="align-self: center; border:1px solid black; width: 70%" >
		<tr>
			<th>Admin ID</th><th>Full Name</th><th>Mobile No.</th><th>Email</th><th>Password</th><th>Action </th>
		</tr>
		<tr>
			<td>${loginAdmin.admin_id}</td>
			<td>${loginAdmin.admin_name}</td>
			<td>${loginAdmin.admin_mobile}</td>
			<td>${loginAdmin.admin_email}</td>
			<td>${loginAdmin.admin_password}</td>
			<td><a href="update-admin-profile/${loginAdmin.admin_id}">Change Profile</a></td>
		</tr>
	</table>

</c:forEach>

<br>
<br>
<br>
<div align="center">
<a href="add-product">Add product</a> &nbsp; | &nbsp; <a href="add-category">Add category</a> &nbsp; | &nbsp; <a href="add-sub-category">Add sub category</a> &nbsp; | &nbsp; <a href="add-purchase">Add Stock</a> &nbsp; | &nbsp; <a href="add-offer">Add offer</a>
</div>
<br>
<br>
<br>
<div>
<div align="center"><a href="list-prouct">View all product</a> &nbsp; | &nbsp; <a href="view-datatable">List Category</a> &nbsp; | &nbsp; <a href="list-sub-categories">List Sub category</a> &nbsp; | &nbsp;<a href="view-stock-datatable">Total Stock</a> &nbsp; | &nbsp; <a href="listOffer">List Offer</a></div> </div>
</body>
</html>