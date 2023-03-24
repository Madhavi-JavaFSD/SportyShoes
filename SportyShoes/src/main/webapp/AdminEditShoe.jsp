<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" java.util.logging.Logger" %>    
    <%@page import="com.example.demo.model.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Shoe> e=(List<Shoe>)request.getAttribute("list"); %>
<%if(e != null && e.size() > 0)
{%>
		<%
		Logger log = Logger.getAnonymousLogger(); 
		int nShoeID = 0;
		String sShoeName ="";
		int nShoePrice = 0;
		int nShoeQuantity = 0;
		
		for(Shoe es:e)
		{
			 nShoeID = es.getShoeID();
			 sShoeName = es.getShoeName();
			 nShoePrice = es.getShoeID();
			 nShoeQuantity = es.getShoeQuantity();
		}%>
<h1>Edit the details for the selected shoe:-</h1>
<form action="updateShoe" id="editShoeForm">

<% log.info( "shoeID value:-" + request.getParameter("shoeID")); %>

  <label for="shoeID">Shoe ID:</label>
  <input type="text" name="shoeID" value="<%=nShoeID%>" readonly><br><br>

  <label for="shoeName">Shoe name:</label>
  <input type="text" id="shoeName" name="shoeName"  value="<%=sShoeName%>"><br><br>
  
  <label for="shoePrice">Shoe Price:</label>
  <input type="number" id="shoePrice" name="shoePrice" value="<%=nShoePrice%>"><br><br>
  
  <label for="shoeQuantity">Shoe Quantity:</label>
  <input type="number" id="shoeQuantity" name="shoeQuantity" value="<%=nShoeQuantity%>" min="0"><br><br>
  
  <input type="submit" value="Submit" form="editShoeForm" value="updateShoe">
</form>
<%}%>

</body>
</html>