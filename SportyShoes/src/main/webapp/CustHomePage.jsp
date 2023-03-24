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
<!-- Page to show Customer after successfully login-->
<div style="background-color:#D8D1E6; width: 100%; height: 100px;">  
 			<h1>Welcome to Sporty Shoes! </h1> 
        </div>  
        
        <div style="width:100%; height: 300px;">  
 			<div style="background-color:#E3C1CA; width: 20%; height: 550px; float:left;">  
				<ul>
				<li><a href="CustSearchShoe.jsp" target="iframe_a">Search Shoe</a></li>		
				<li><a href="/getAllShoeForCustomer" target="iframe_a">Display Shoes</a></li>			
				<li><a href="/customerLogout" target="_top">Logout</a></li>				
				</ul>
        	</div>    
        	<div id= "targetDiv" style="background-color:#FFFFB7; width:80%; height: 550px; float:left;"> 
  				<iframe name="iframe_a" height="300px" width="100%" title="Iframe Example"></iframe>
       		</div>  
        </div>  
</body>
</html>