<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Tour Agency</title>
	<!-- scripts -->
	<!--  css -->
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<h1></h1>
			<p>Hello,<c:out value=" ${user.name}!"/><br />
			<c:out value=" ${user.role}"/><br />
			<a href="controller?command=exit"><fmt:message key="main.exit"/></a></p>
		</div>
		<div class="header_nav">
			<a href="login.jsp">Login</a>
			<a href="controller?command=home">Main</a>
			<c:if test="${not empty user and user.role eq 'user'}"><a href="controller?command=viewMyTours&userId=${user.id }">View My Tours</a></c:if>
			<c:if test="${not empty user and user.role eq 'admin'}"><a href="controller?command=viewAllUsers">View Users</a></c:if>
		</div>
	
		<div class="tours">
			<h3>${successMessage}</h3>
		</div>
	</div>
</body>
</html>