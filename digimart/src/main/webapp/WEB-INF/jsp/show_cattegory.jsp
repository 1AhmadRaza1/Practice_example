<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">	
<script type="text/javascript" src="javascript/cattegory_list_datatable.js"></script>

</head>
<body>
<br>
<br>
 <div><a href="add-category">Add category</a></div>

<form action="">
<table id="example1" style="align-self: center; border:1px solid black; width: 70%" >
	<thead>
		<tr>
			<th>Category Name</th><th>Category Priority</th><th>Description</th><th>Image</th><th> Action </th>
		</tr>
	</thead>
</table>
</form>
</body>
</html>