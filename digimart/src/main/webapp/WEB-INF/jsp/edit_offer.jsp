<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Offer </title>
<link href="../css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
	<form:form modelAttribute="editoffer" method="POST" action="${pageContext.request.contextPath}/edit-new-offer">
		<table align="center">
			<tr>
				<td colspan="2" align="center" id="ltitle">Update Offer</td>
			</tr>
			<form:hidden path="offer_id" id="offer_id" />
			<tr>
				<td>Offer Name </td><td><form:input path="offer_name" id="offer_name" /></td>
			</tr>
			<tr>
				<td>Offer Start Date </td><td><input type="date" name="offer_start_date" id="offer_start_date" /></td>
			</tr>
			<tr>
				<td>Offer End Date</td><td><input type="date" name="offer_end_date" id="offer_end_date" /></td>
			</tr>
			<tr>
				<td>Offer Description </td><td><form:input path="offer_description" id="offer_description" /></td>
			</tr>
			<tr>
				<td>Offer Code </td><td><form:input path="offer_code" id="offer_code" /></td>
			</tr>
			<tr>
					<td align="center"><input type="submit" value="Save" id="save_admin"> </td><td align="center"><input type="button" value="Cancel" id="cancel_admin"></td>
				</tr>
		</table>
	</form:form>
</body>
</html>