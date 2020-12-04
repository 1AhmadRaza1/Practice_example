<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase | Product </title>
<link href="css/style_tag.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="javascript/try_blur.js"></script>
</head>
<body id="b1">
<br>
<br>
<br>

	<input type="hidden" id="last_purchase_id" name="last_purchase_id" />
	<table align="center">
		<thead>
				<tr>
					<td colspan="3" id="ltitle" align="center"> Purchase Detail </td>
				</tr>
				<tr>
					<td align="center">Supplier name <font color="red">*</font></td><td colspan="2" align="right">
						<select name="suplier_detail_id" id="suplier_detail_id">
							<option value="-1">Select Supplier name</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center">Date <font color="red">*</font></td><td align="right" colspan="2"><input type="date" name="purchaseDate" id="purchaseDate" /></td>
				</tr>
					<tr><td colspan="3"><button id="addproduct" name="addproduct" >Add Product</button></td></tr>
					<tr><td colspan="2">Sr. No.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Product Name</td>
						<td>Product Quantity</td>
					</tr>
					
				</thead>
				<tbody id="addRow">
				
				</tbody>	
				<tr><td colspan="3">  </td></tr>
				<tr>
					<td align="right"><input type="button" value="Save" id="updatePurchase"> </td><td align="right"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</body>
</html>