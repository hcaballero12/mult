<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Clorox Comapany Admin</title>
</head>
<body>
<div class="row">
  <div class="col-xs-9">
  <img alt="logo" src="/EMSN/logo.png">
  
  <br>
  <br>
  <br>
  <form action = "login.do" method = "post" class="form-inline">
  <div class="form-group">
    <button type = "submit" value = "add" name = "action" class="btn btn-danger">Add Employee</button>
  </div>
  <div class="form-group">
    <button type = "submit" value = "update" name = "action" class="btn btn-danger">Update Employee</button>
  </div>
  <div class="form-group">
    <button type = "submit" value = "delete" name = "action" class="btn btn-danger">Delete Employee</button>
  </div>
  <div class="form-group">
    <button type = "submit" value = "view" name = "action" class="btn btn-danger">View Employee</button>
  </div>
  <div class="form-group">
    <button type = "submit" value = "profile" name = "action" class="btn btn-danger">My Profile</button>
  </div>
  
</form>
      


  
  
  
  </div>
  
</div>

</body>
</html>