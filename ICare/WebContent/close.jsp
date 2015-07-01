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
<title>Insert title here</title>
</head>
<body>
<form action = "login.do" method = "post" class="form-horizontal" >
  
	  <div class="form-group">
	    <label for="name" class="col-sm-2 control-label">Issue Number</label>
	    <div class="col-sm-10">
	      <input type="text" name ="id" class="form-control" value='${issue.getIssueNum()}' id="name" placeholder="Issue Number">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="last" class="col-sm-2 control-label">Description</label>
	    <div class="col-sm-10">
	      <input type="text" name ="last" class="form-control" value='${issue.getDescription()}' id="last" placeholder="Description">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="user" class="col-sm-2 control-label">Priority</label>
	    <div class="col-sm-10">
	      <input type="text" name ="user" class="form-control" value='${issue.getPriority()}' id="user" placeholder="Priority">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="password" class="col-sm-2 control-label">TimeStamp</label>
	    <div class="col-sm-10">
	      <input type="text" name ="pass" class="form-control" value='${issue.getTimestamp()}' id="pass" placeholder="TimeStamp">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="clearance" class="col-sm-2 control-label">User Id</label>
	    <div class="col-sm-10">
	      <input type="text" name ="clearance" class="form-control" value='${issue.getEmployee().getEmpId()}' id="clearance" placeholder="User Id">
	    </div>
	  </div>
	 
	<button type="submit" class="btn btn-primary btn-lg btn-block" value = "close" name = "action">Close Issue</button>
</form>
</body>
</html>