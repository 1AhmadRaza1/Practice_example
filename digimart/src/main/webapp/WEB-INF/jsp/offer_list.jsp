<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style_tag.css" rel="stylesheet">
</head>
<body id="b1">
<form:form>

<div align="center"><a href="add-offer">Add offer</a></div>
<br>
<br>
<br>
<div align="center"><font color="blue">Offer List</font></div>

	<table align="center" style="width: 70%">
		<tr>
			<th align="center">Offer Id</th><th align="center" width="200px">Offer Name</th><th align="center" width="200px">Offer Start Date</th><th align="center" width="200px">Offer Ende Date</th><th align="center" width="200px">Offer Description</th><th align="center" width="200px">Offer Code</th><th align="center" width="200px"> Action </th>
		</tr>
		<c:forEach var="offer" items="${offerList}">
		<tr>
			<td align="center">${offer.offer_id}</td><td width="200px" align="center">${offer.offer_name}</td><td align="center" width="200px">${offer.offer_start_date}</td><td align="center" width="200px">${offer.offer_end_date}</td><td align="center" width="200px">${offer.offer_description}</td><td align="center" width="200px">${offer.offer_code}</td><td align="center" width="200px"><a href="edit-offer/${offer.offer_id}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete-offer/${offer.offer_id}"> Delete </a></td>
		</tr>
		</c:forEach>
	</table>
</form:form>
</body>
</html>