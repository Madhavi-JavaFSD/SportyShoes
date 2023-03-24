<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1 {
  text-align: center;
}
</style>
</head>
<body>


  <div style="background-color:#D8D1E6; width: 100%; height: 100px;">  
        <br>
 			<h1>Welcome to Sporty Shoes! </h1> 
        </div>  
       	<div name= "targetDiv" style="background-color:#FFFFB7; width:100%; height: 550px; float:left; text-align:center;"> 
 			You have encountered an Error! The error message is as
follows:<br><br>
<%= request.getAttribute("ErrorText") %>
<br>
      	</div> 
</body>
</html>