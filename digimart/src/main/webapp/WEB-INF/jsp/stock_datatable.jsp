<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock page</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">	
<script type="text/javascript" src="javascript/stock_datatable.js"></script>
</head>
<body>
<div><a href="add-purchase">Add stock</a></div>
<br>
<br>


<form action="">
<table id="example1" style="align-self: center; border:1px solid black; width: 70%" >
	<thead>
		<tr>
			<th>Supplier Name</th><th>Product Name</th><th>Number of Stock</th><th>Company Name</th><th>Amount per Product</th><th>Stock Date</th><th>Product Image </th>
		</tr>
	</thead>
</table>
</form>
</body>
</html>