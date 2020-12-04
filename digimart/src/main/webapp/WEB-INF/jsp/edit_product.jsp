<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Update | Product Page </title>
<link href="../css/style_tag.css" rel="stylesheet">
</head>
<body>

<br>
<br>
<br>
<form:form modelAttribute="getProductById" method="POST" action="${pageContext.request.contextPath}/edit-new-product" enctype="multipart/form-data">
	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Edit Product </td>
				</tr>
					<form:hidden path="product_master_id" id="product_master_id" />
				<tr>
					<td align="center">Category Name<font color="red">*</font></td><td align="center">
						<form:select path="cattegory_master_id" id="cattegory_master_id" >
							<form:option value="-1"> -- Select Category Name -- </form:option>
							<form:options items="${cattegoryName}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td align="center">Sub Category Name<font color="red">*</font></td><td align="center">
						<form:select path="sub_cattegory_master_id" id="sub_cattegory_master_id" >
							<form:option value="-1">-- Select Sub cattegory --</form:option>	
							<form:options items="${subCattegoryName}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td align="center">Product Name<font color="red">*</font></td><td align="center"><form:input path="product_name" id="product_name" /></td>
				</tr>
				<tr>
					<td align="center">Product description <font color="red">*</font></td><td align="center"><form:textarea path="product_description" id="product_description" /></td>
				</tr>
				<tr>
					<td align="center">price <font color="red">*</font></td><td align="center"><form:input path="product_prise" id="product_prise" /></td>
				</tr>
				<tr>
					<td align="center">Product Photo <font color="red">*</font></td><td align="center"><input type="file" name="product_photo" id="product_photo" /></td>
				</tr>
				<tr>
					<td align="center">Expiry Date <font color="red">*</font></td><td align="center"><input type="date" name="product_expiry_date" id="product_expiry_date" /></td>
				</tr>
				<tr>
					<td align="center">Manufacture Date<font color="red">*</font></td><td align="center"><input type="date" name="product_manufacture_date" id="product_manufacture_date" /></td>
				</tr>
				<tr>
					<td align="center">Manufacture Company <font color="red">*</font></td><td align="center"><form:input path="product_company_name" id="product_company_name" /></td>
				</tr>
				<tr>
					<td align="center">Discount Type  <font color="red">*</font></td><td align="center"><form:radiobutton path="product_discount_type" value="amount"/> Amount <form:radiobutton path="product_discount_type" value="percentage"/> Percentage </td>
				</tr>
				<tr>
					<td align="center">Product Discount <font color="red">*</font></td><td align="center"><form:input path="product_discount" id="product_discount" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>
</body>
</html>