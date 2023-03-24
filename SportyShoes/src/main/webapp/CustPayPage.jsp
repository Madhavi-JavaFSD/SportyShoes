<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.demo.model.*" %>
    <%@page import="java.util.*" %>
<%@ page import=" java.util.logging.Logger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type='text/javascript'>
/*window.onload = function() { 
 	window.addEventListener('load', function () 
			{
	document.getElementById("shoeName").setAttribute("value", request.getParameter("shoeName"));
	}); */
	
	/* function myFunction() {
		  alert("Page is loaded");
		  //log.info("request.getParameter("shoeName")---" + request.getParameter("shoeName"));
		  document.getElementById("shoeNameText").setAttribute("value", request.getParameter("shoeName"));
		} */
</script>
</head>
<body onload="myFunction()">
<!-- Page to show Admin when she clicks on one of the 'BuyNow' buttons-->
<h1>...Redirecting to your Bank.....</h1>
 <%List<Shoe> e=(List<Shoe>)request.getAttribute("list"); 
 int nShoeID =0;
 String sShoeName = null;
 int nShoePrice = 0;
 int nShoeQuantity = 0;%>
 <%if(e != null && e.size() > 0)
	{
	 for(Shoe es:e)
	 {
		 nShoeID = es.getShoeID();
		sShoeName = es.getShoeName();
		nShoePrice = es.getShoePrice();
		nShoeQuantity = es.getShoeQuantity();
	 }
	}
 %>
  
<form action="/addOrder" name="buyShoeForm" id="buyShoeForm">
<%Logger log = Logger.getAnonymousLogger(); %>

 <input type="hidden" id="shoeIDText" name="shoeIDText"value="<%=nShoeID%>" readonly><br><br>

  <label for="shoeName">Shoe Name:</label>
  <input type="text" id="shoeNameText" name="shoeNameText"value="<%=sShoeName%>" readonly><br><br>
  
  <label for="shoePrice">Shoe Price:</label>
  <input type="text" id="shoePrice" name="shoePrice" value="<%=nShoePrice%>" readonly><br><br>
  
  <label for="shoeQuantity">Shoe Quantity:</label>
  <input type="text" id="shoeQuantity" name="shoeQuantity" value= "<%=nShoeQuantity%>" ><br><br>

  <label for="bankID">Enter bank ID(Enter either 1 or 2):</label>
  <input type="text" id="bankID" name="bankID"><br><br>
  
  <input type="submit" value="Proceed to Pay" form="buyShoeForm">
</form>
</body>
</html>