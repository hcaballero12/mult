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
<title>Clorox Company Admin Add</title>
</head>
<body>
<div class="row">
  <div class="col-xs-9">
  <img alt="logo" src="/EMSN/logo.png">
  
  
  <form action = "login.do" method = "post" class="form-horizontal" enctype="multipart/form-data">
  
	  <div class="form-group">
	    <label for="name" class="col-sm-2 control-label">First Name</label>
	    <div class="col-sm-10">
	      <input type="text" name ="name" class="form-control" id="name" placeholder="FirstName">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="last" class="col-sm-2 control-label">Last Name</label>
	    <div class="col-sm-10">
	      <input type="text" name ="last" class="form-control" id="last" placeholder="LastName">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="user" class="col-sm-2 control-label">User</label>
	    <div class="col-sm-10">
	      <input type="text" name ="user" class="form-control" id="user" placeholder="User">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="password" class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input type="text" name ="pass" class="form-control" id="pass" placeholder="Password">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="clearance" class="col-sm-2 control-label">Clearance</label>
	    <div class="col-sm-10">
	      <input type="text" name ="clearance" class="form-control" id="clearance" placeholder="Clearance">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="clearance" class="col-sm-2 control-label">Upload Image</label>
	    <div class="col-sm-10">
	      <input type="file" name="file" class="form-control" />
	    </div>
	  </div>
	  
	<button type="submit" class="btn btn-primary btn-lg btn-block" value = "addEmp" name = "action">Add Employee</button>
</form>
  
  
  
  </div>
  
</div>

</body>
</html>