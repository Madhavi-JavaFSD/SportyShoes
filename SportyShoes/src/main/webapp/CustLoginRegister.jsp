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
label {
width:240px;
display:inline-block;
text-align: right;
}
</style>
</head>
<body>
<!-- Page to show User to Login/Register when she clicks on 'User' on the Index Page-->

    <div style="background-color:#D8D1E6; width: 100%; height: 100px;">  
 	<h1>Welcome to Sporty Shoes! </h1> 
    </div>  
        
    <div style="width:100%; height: 300px;">  
	 	<div style="background-color:#E3C1CA; width: 20%; height: 550px; float:left;">  
			<ul>
			<li><a href="CustLogin.jsp" target="iframe_b">Login</a></li>	
			<li><a href="CustRegister.jsp" target="iframe_b">Register</a></li>				
			</ul>
	    </div>    
	    <div id ="targetDiv" style="background-color:#FFFFB7; width:80%; height: 550px; float:left;"> 
	  		<iframe name="iframe_b" height="300px" width="100%" title="Iframe Example"></iframe>
	    </div>  
    </div> 
</body>
</html>