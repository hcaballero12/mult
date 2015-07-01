<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clorox Comapany Admin Delete</title>
</head>
<body>
<div class="row"> 
  <div class="col-xs-9">
  <img alt="logo" src="/EMSN/logo.png">
  
  <br>
  <br>
  <br>
  <form action = "login.do" method = "post" class="form-inline">
	  <table class="table table-condensed">
	  	<tr class= "success">
	  		<th></th>
	  		<th>Id</th>
	  		<th>First Name</th>
	  		<th>Last Name</th>
	  		<th>User</th>
	  		<th>Password</th>
	  		<th>Clearance</th>
	  	</tr>
	  	<c:forEach items= "${employees}" var="current">
        		<tr>
         			 <td><input type="radio" name="id" id="inlineRadio3" value="<c:out value="${current.getId()}" />"> </td>
					 <td><c:out value="${current.getId()}" /></td>
         			 <td><c:out value="${current.getFirstname()}" /></td>
         			 <td><c:out value="${current.getLastname()}" /></td>
          			 <td><c:out value="${current.getUser()}" /></td>
          			 <td><c:out value="${current.getPassword()}" /></td>
          			 <td><c:out value="${current.getClearance()}" /></td>
        		</tr>
      	</c:forEach>
	</table>
  <div class="form-group">
    
  </div>
  <button type="submit" class="btn btn-primary btn-lg btn-block" value = "delEmp" name = "action">Delete Employee</button>
  
</form>
      
  </div>
  
</div>

</body>
</html>