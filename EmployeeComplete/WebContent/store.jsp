<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>StoreX</title>
</head>
<body>
<h1>Welcome To X Store Your Best On "Legit" Anime Goods</h1>
<h2>Please Choose From Our Goods :</h2>
<form action = "addProduct" method = "POST">
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Description</th>
		<th>Price</th>
		<th>Qty</th>
		<th>Buy</th>
	</tr>
	
<%  ResultSet products = (ResultSet)session.getAttribute("products");

	while(products.next()){%>
	<tr>
		<td><%= products.getString("pid")%></td>
		<td><%= products.getString("pname")%></td>
		<td><%= products.getString("pdesc")%></td>
		<td><%= products.getString("price")%></td>
		<td><%= products.getString("qty")%></td>
		<td><input type ="text" name ="<%= products.getString("pid")%>"></td>
	</tr>
	
	<%}%>
</table>
<input type = "submit" value = "Buy">
</form>
</body>
</html>