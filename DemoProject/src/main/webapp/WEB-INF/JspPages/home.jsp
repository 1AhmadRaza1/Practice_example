<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<marquee><h2>Welcome To Student Portal </h2></marquee>

<br>
<br>

<br>
<div align="center"><a href="${pageContext.request.contextPath}/registration.html">New Student</a>  </div>

<br>
<br>
<div align="center"><a href="${pageContext.request.contextPath}/studentlist.html">Show All</a></div>
</body>
</html>