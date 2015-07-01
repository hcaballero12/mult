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
<title>Clorox Company</title>
</head>
<body>
<div class="row">
  <div class="col-xs-9">
  <img alt="logo" src="/EMSN/logo.png">
  
  
  <form action = "login.do" method = "post" class="form-horizontal">
  <div class="form-group">
    <label for="user" class="col-sm-2 control-label">User</label>
    <div class="col-sm-10">
      <input type="text" name ="user" class="form-control" id="user" placeholder="User">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" name = "pass" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="radio">
        <label>
          	<input type="radio" name="type" value="admin" checked>Manager
          	<br>
			<input type="radio" name="type" value="emp">Employee
        </label>
      </div>
    </div>
  </div>
<button type="submit" class="btn btn-primary btn-lg btn-block" value = "login" name = "action">SUBMIT</button>
</form>
  
  
  
  </div>
  
</div>

</body>
</html>