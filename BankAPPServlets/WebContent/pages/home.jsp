<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mrs. Piggy Bank</title>
<link rel="stylesheet" type="text/css" href="pages/css/form.css" />

</head>

<body>
    <!--Main Container  -->
	<div class="wrap">
		<!--Title  -->
		<a>Welcome to Mr. Piggy Bank<a>
				<!--Form Piggy Pic  -->
				<div class="avatar">
					<img src="pages/img/logo.png">
				</div>
				<!--Logging Form  -->
				<form id="form" action="login" method="post">
					<input type="text" name="user" placeholder="username" required>
					<div class="bar">
						<i></i>
					</div>
					<input type="password" name="pass" placeholder="password" required>
					<a href="register" class="register_link">Register</a> <input
						class="buttonS" type="submit" value="Sign In">
				</form> 
				<!--If there are any errros display them  -->
				<c:if test="${errorMessage !=null}">
					<p>
						<c:out value="${errorMessage}" />
					<p>
				</c:if>
	</div>


</body>
</html>