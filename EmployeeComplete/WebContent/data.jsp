<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.Employee" import="dao.Department"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>StoreX</title>
</head>
<body>
	<h1>Super Employee Table</h1>


	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Department</th>

		</tr>
		<c:forEach var="employee" items="${results}">
			<tr>


				<td><c:out value="${employee.getSempid()}" /></td>

				<td><c:out value="${employee.getName()}" /></td>

				<td><c:out value="${employee.getEmail()}" /></td>

				<td><c:out value="${employee.getSdept().getName()}" /></td>



			</tr>
		</c:forEach>


	</table>



</body>
</html>