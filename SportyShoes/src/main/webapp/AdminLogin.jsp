<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style>
h1 {
  text-align: center;
}
label {
width:240px;
display:inline-block;
text-align: right;
}
</style>
</head>
<body>
 <div style="background-color:#D8D1E6; width: 100%; height: 100px;">  
 <br>
 	<h1>Welcome to Sporty Shoes! </h1> 
 </div> 
        
 <div name= "targetDiv" style="background-color:#FFFFB7; width:100%; height: 550px; float:left; text-align:center;"> 
 	<br><br><br><br>
	<form action="/checkIfAdmin" id="adminLoginform">
		  <label for="adminEmail">Admin Email:</label>
		  <input type="text" id="adminEmail" name="adminEmail"><br><br>
		    
		  <label for="adminQuantity">Password:</label>
		  <input type="password" id="adminPass" name="adminPass" min="0"><br><br>
		  
		  <input type="submit" value="Submit" form="adminLoginform">
	</form>
 </div>
</body>
</html>