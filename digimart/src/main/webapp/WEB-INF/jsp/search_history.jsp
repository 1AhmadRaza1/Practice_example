<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search | History</title>
<link href="css/style_tag.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="javascript/search_sales_purchase_history.js"></script>
</head>
<body style="padding-top: 10px;">

<div align="center"><button id="sales_link">Search Sales</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="purchase_link">Search Purchase</button></div>
		<br>
		<br>
		<br>
		<div id="sales_history">
				<table style="border: solid 1px; color: black; width: 70%;" align="center">
				<tr>
					<td colspan="4" id="ltitle" align="center"> Search Sales History </td>
				</tr>
				<tr>
					<td>Customer Name<font color="red">*</font></td>
					<td>
						<select name="customerName" id="customerName">
							<option value="-1"> -- Select customer name --  </option>
						</select>
					</td>
					<td>Mobile Number </td><td><input type="text" id="mobileNumber" name="mobileNumber"></td>
				</tr>
				<tr>
					<td>To Date<font color="red">*</font></td><td><input type="date" id="toDate" name="toDate"></td><td>From Date<font color="red">*</font></td><td><input type="date" id="fromDate" name="fromDate"></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button" id="sales" name="sales" style="width: 200px;" value="Sales History"></td><td colspan="2"><input type="button" style="width: 200px;" value="Reset" id="cancel_sales" name="cancel_sales"></td>
				</tr>
			</table>
		</div>
		
		<div id="purchase_history">
			<table style="border: solid 1px; color: black; width: 70%;" align="center">
				<tr>
					<td colspan="4" id="ltitle" align="center"> Search Purchase History </td>
				</tr>
				<tr>
					<td>Supplier Name<font color="red">*</font></td>
					<td>
						<select name="supplierName" id="supplierName">
							<option value="-1"> -- Select Supplier name -- </option>
						</select>
					</td>
					<td>Mobile Number </td><td><input type="text" id="mobileNumber" name="mobileNumber"></td>
				</tr>
				<tr>
					<td>To Date<font color="red">*</font></td><td><input type="date" id="toDate" name="toDate"></td><td>From Date<font color="red">*</font></td><td><input type="date" id="fromDate" name="fromDate"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" style="width: 200px;" value="Purchase History" id="purchase" name="purchase"></td><td colspan="2" align="center"><input type="button" id="cancel_purchase" name="cancel_purchase" style="width: 200px;background-color: red;" value="Reset"></td>
				</tr>
			</table>
		</div>
</body>
</html>