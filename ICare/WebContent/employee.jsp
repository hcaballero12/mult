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
<title>ICare Management System</title>
</head>
<h1>ICare Managment System</h1>
	
	<div class="row"> 
  <div class="col-xs-9">
  
  
  <br>
  <br>
  <br>
  <form action = "login.do" method = "post" class="form-inline">
	  <table class="table table-condensed">
	  	<tr class= "success">
	  		
	  		<th>Issue Num</th>
	  		<th>Priority</th>
	  		<th>Status</th>
	  		<th>Date</th>
	  		<th>Description</th>
	  	</tr>
	  	<c:forEach items= "${employee}" var="current">
        		<tr>
         			 
					 <td><c:out value="${current.getIssueNum()}" /></td>
         			 <td><c:out value="${current.getPriority()}" /></td>
         			 <td><c:out value="${current.getStatus()}" /></td>
          			 <td><c:out value="${current.getTimestamp()}" /></td>
          			 <td><c:out value="${current.getDescription()}" /></td>
          			
        		</tr>
      	</c:forEach>
	</table>
  <div class="form-group">
    
  </div>
  	<input type ="hidden" name = "id"  value="${empId}">
	<button type="submit" class="btn btn-primary btn-lg btn-block" value = "openIssue" name = "action">Open Issue</button>
  
</form>

</html>