<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding= "UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="pages/js/bankscript.js"></script>
<title>Mrs. Piggy Bank</title>
</head>
<body>
	<center>
		<h1>Welcome to Mr. Piggy Bank</h1>
		<form action="balance" method="post" id = "balance">
			<table>
				<tr>
					<td><a href="pages/deposit.jsp"> <input type="button"
							value="Deposit" id="deposit">
					</a></td>
					<td><a href="pages/withdraw.jsp"> <input type="button"
							value="Withdraw" id ="withdraw">
					</a></td>
					<td><input type="submit" value="Balance"></td>
				</tr>

			</table>

		</form>


		<br>
		<br>
		<div id="form1">
			<!-- Dynamic Form Div -->
		</div>

		</div>

	</center>
</body>
</html>