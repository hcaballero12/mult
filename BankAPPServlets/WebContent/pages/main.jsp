<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Piggy Bank</title>
<link rel="stylesheet" type="text/css" href="pages/css/demo.css" />
<link rel="stylesheet" type="text/css" href="pages/css/style.css" />
<link rel="stylesheet" type="text/css" href="pages/css/form.css" />

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700,300,300italic'
	rel='stylesheet' type='text/css'>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="pages/js/bankscript.js"></script>



<!--[if lt IE 9]>
			<style>
				.content{
					height: auto;
					margin: 0;
				}
				.content div {
					position: relative;
				}
			</style>
		<![endif]-->
</head>
<body>
	<!--Main Container  -->
	<div class="container">
		<!-- top bar -->
		<div class="codrops-top">
			<span class="right"> <a><c:out value="${user}" /></a> 
			<a href="logout"><strong>Log Out</strong> </a>
			</span>
			<div class="clr"></div>
		</div>

		<header>
			<!--Title -->
			<h1>
				Piggy <img id="pig" src="pages/img/logo.png" alt="logo" />Bank
			</h1>
			<h2>No Need To Break The Piggy</h2>
		</header>

		<!--body container -->
		<div id="main-container">
			<div id="container">

				<!--Top Menu -->
				<form action="balance" method="post" id="balance">
					<table>
						<tr>

							<td><input type="button" class="btn" value="Home" id="Home">
								</a></td>
							<td><input type="button" class="btn" id="btn-deposit"
								value="Deposit"> </a></td>
							<td><input type="button" class="btn" id="btn-withdraw"
								value="Withdraw"> </a></td>
							<td><input type="submit" value="Balance" class="btn"
								id="btn-balance"></td>
						</tr>

					</table>

				</form>
			</div>
			<!-- Text Container -->
			<div id="container-data">

				<div id="welcome">
					<!-- Get First name and last name from session -->
					<h2>
						Welcome Back
						<c:out value="${first}" />
						<c:out value="${last}" />
					</h2>
					<p>We appreciate your business</p>
				</div>
				<!--div for dynamic content -->
				<div id="form1" class="wrap">

					<!-- Dynamic Form Div -->
				</div>

			</div>
		</div>
	</div>
	
</body>
</html>