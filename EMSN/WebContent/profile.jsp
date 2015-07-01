<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clorox Comapany Employee View</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-9">
			<img alt="logo" src="/EMSN/logo.png">
			<div class="row">
				<div class="col-xs-8 col-sm-6">
					<div class="pull-right"><img alt="profile" src='<c:out value="${eview.getImage()}" />'></div>
					
				</div>
				<div class="col-xs-4 col-sm-6">
					<form action="login.do" method="post" class="form-inline">
						<table class="table table-condensed">
							<tr class="success">
								

							<tr>
								<tr class="text-primary">Id: <c:out value="${eview.getId()}" /></tr>
								<tr class="text-primary">Firstname: <c:out value="${eview.getFirstname()}" /></tr>
								<tr class="text-primary"> Lastname: <c:out value="${eview.getLastname()}" /></tr>
								<tr class="text-primary">User:<c:out value="${eview.getUser()}" /></tr>
								<tr class="text-primary">Pasword:<c:out value="${eview.getPassword()}" /></tr>
								<tr class="text-primary">Clearance:<c:out value="${eview.getClearance()}" /></tr>
							</tr>
						</table>
						<div class="form-group">
						<button type="submit" class="btn btn-primary btn-lg btn-block"
							value="returnadview" name="action">Home</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	

</body>
</html>