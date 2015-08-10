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

	<!--Registration Form -->
	<div class="wrap">
		<a>Please Register Below<a>
				<div class="avatar">
					<img src="pages/img/logo.png">
				</div>
				<form id="form" action="register" method="post">
					<input type="text" name="first" placeholder="Firstname" required>
					<div class="bar">
						<i></i>
					</div>
					<input type="text" name="last" placeholder="Lastname" required>
					<div class="bar">
						<i></i>
					</div>
					<input type="text" name="user" placeholder="Username" required>
					<div class="bar">
						<i></i>
					</div>
					<input type="password" name="pass" placeholder="Password" required>

					<input class="buttonS" type="submit" value="Sign In">
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