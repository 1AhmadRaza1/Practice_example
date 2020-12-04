<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="javascript/script_to_controller_to script.js"></script>
</head>
<body>
<form:form modelAttribute="p">
	<table style="border: solid 1px; color: black; width: 70%;" align="center">
		<tr>
			<td>Name </td><td><form:input id="name" path="name" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="button" id="sales" name="sales" style="width: 200px;" value="Sales History"></td><td colspan="2"><input type="button" style="width: 200px;" value="Purchase History" id="purchase" name="purchase"></td>
		</tr>
	</table>
</form:form>
</body>
</html>