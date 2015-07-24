<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <center>
        <form action="operation" method = "post">
            <table>
            	<tr>
            		<td><label for="amount">Withdraw Amount:</label></td>
            		<td><input type="text" id="amount" name="amount"></td>
            	</tr>
            	<tr>
            		<td><input type="hidden" id="operation" name="operation" value="withdraw"></td>
            		<td><input type="submit" value="Submit">
                		<a href="main.jsp">
   						<input type="button" value="Home">
						</a>
					</td>
            	</tr>
            
            </table>

            
        </form>
   </center>

</body>
</html>