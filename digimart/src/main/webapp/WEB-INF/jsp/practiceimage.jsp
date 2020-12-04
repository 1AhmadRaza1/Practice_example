<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" modelAttribute="uploadimage" action="add-new-image" enctype="multipart/form-data">
	<div align="center">
		Name : <div><form:input path="name" name="name" id="name" /></div>
		<br>
		Image Upload : <div><input type="file" name="image" id="image" /></div>
		Name : <div><input type="submit" value="Save" /></div>
	</div>

</form:form>

</body>
</html>