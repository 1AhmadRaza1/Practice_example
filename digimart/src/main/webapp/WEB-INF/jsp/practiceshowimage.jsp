<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<table border="1">
	<tr><th>Id </th><th>Name</th><th>Images</th></tr>
	<c:forEach var="listimg" items="${imageList}">
	<tr><td>${listimg.imageid}</td><td>${listimg.name}</td><td><img src="data:image/jpg;base64,${listimg.image}" height="100px" width="100px"></td></tr>
	</c:forEach>
</table>
</body>
</html>