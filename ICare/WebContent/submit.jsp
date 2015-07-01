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
<title>ICare Management System</title>
</head>
<body>


	<h1>Open Issue</h1>
	
	  <form action ="login.do" method = "post" class="form-horizontal" >
  	  
  	  <input type ="hidden" name = "id"  value="${empId}">
	  <div class="form-group">
	    <label for="Priority" class="col-sm-2 control-label">Priority:</label>
	    <div class="col-sm-10">
		   <select class="form-control" id="sel1" name = "priority">
				<option value="1">1</option>
		 		<option value="2">2</option>
		  		<option value="3">3</option>
			</select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="Department" class="col-sm-2 control-label">Department:</label>
	    <div class="col-sm-10">	      		
			<select class="form-control" id="sel1" name = "department">
				<option value="HR">HR</option>
		 		<option value="IT">IT</option>
		  		<option value="Marketing">Marketing</option>
		  		<option value="Engineering">Engineering</option>
			</select>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="Description" class="col-sm-2 control-label">Description:</label>
	    <div class="col-sm-10">	
			<textarea class="form-control" rows="5" id="comment" cols="15" name =description></textarea>
	    </div>
	  </div>
	<button type="submit" class="btn btn-primary btn-lg btn-block" value = "createIssue" name = "action">Open Issue</button>
</form>

</body>
</html>