<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="../css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
<br>
<br>
<br>
<form:form modelAttribute="getSubCategoryById" method="POST" action="${pageContext.request.contextPath}/edit-new-sub-category" enctype="multipart/form-data">

	<table align="center">
				<tr>
					<td colspan="2" id="ltitle" align="center"> Add Sub Category Detail </td>
				</tr>
				<form:hidden path="sub_cattegory_master_id" id="sub_cattegory_master_id"/>
				<tr>
					<td align="center">Category Name <font color="red">*</font></td>
						<td>
							<form:select path="cattegory_master_id" id="cattegory_master_id">
								<form:option value="-1"> -- Select Cattegory Name --</form:option>
								<form:options items="${cattegoryName}" />
							</form:select>
						</td>
				</tr>
				<tr>
					<td align="center">Sub Category Name <font color="red">*</font></td><td align="center"><form:input path="sub_cattegory_name" id="sub_cattegory_name"/></td>
				</tr>
				<tr>
					<td align="center">Sub Category Photo <font color="red">*</font></td><td align="center"><input type="file" name="sub_cattegory_photo" id="sub_cattegory_photo" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
			</table>
</form:form>


</body>
</html>