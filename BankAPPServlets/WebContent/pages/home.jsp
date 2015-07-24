<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mrs. Piggy Bank</title>
</head>
<body>
	<center>
		<h1>Welcome to Mr. Piggy Bank</h1>
		<form action="login" method="post">

			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" for="Username" name ="user" Required></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" for="Password"  name = "pass" Required></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>


			</table>

		</form>
	</center>
</body>
</html>