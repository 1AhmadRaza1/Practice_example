<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category </title>
<link href="css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
<div align="center">${responseString}</div>
<br>
<br>
<br>
<form:form modelAttribute="addCategory" method="post" action="add-new-category" enctype="multipart/form-data">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Add Category Detail </td>
				</tr>
				<tr>
					<td align="center">Category Name <font color="red">*</font></td><td align="center"><form:input path="cattegory_name" id="cattegory_name" /></td>
				</tr>
				<tr>
					<td align="center">Category Priority <font color="red">*</font></td><td align="center"><form:input path="cattegory_priority" id="cattegory_priority" /></td>
				</tr>
				<tr>
					<td align="center">Category Description <font color="red">*</font></td><td align="center"><form:input path="cattegory_description" id="cattegory_description" /></td>
				</tr>
				<tr>
					<td align="center">Category Photo <font color="red">*</font></td><td align="center"><input type="file" name="cattegory_photo" id="cattegory_photo" /></td>
				</tr>	
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>


</body>
</html>