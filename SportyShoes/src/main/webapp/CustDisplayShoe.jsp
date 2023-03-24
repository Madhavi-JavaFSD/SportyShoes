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
<style>
th, td {
  border-style: dotted;
}
</style>
</head>
<body>
<%List<Shoe> e=(List<Shoe>)request.getAttribute("list"); %>
<%if(e != null && e.size() > 0)
	{
	
		Logger log = Logger.getAnonymousLogger(); %>
		<table border="1">
		<tr><th>Shoe Name</th><th> Price</th><th> Quantity</th><th> Buy</th></tr>
		<h1><i>List of Shoes</i></h1>
		<%for(Shoe es:e){%>
			<%int shoeID = es.getShoeID();%>
			<form action="/findShoeByID">
			<tr>
			<!--  <td><%=shoeID%></td> -->
			<td><%=es.getShoeName()%></td>
			<td><%=es.getShoePrice()%></td>
			<td><%=es.getShoeQuantity()%></td>			
			<!-- <td>
				<a href="/findShoeByID">
				<input type="submit" value="Buy Now" />
				</a>
			</td>-->
			<% 
			int nShoeQuantity = es.getShoeQuantity();
			if(nShoeQuantity == 0)
			{%>				
				<td>
				<a href="/findShoeByID">
				<input type="submit" value="Buy Now" disabled/>
				</a>
			</td>
			<%}
			else if(nShoeQuantity > 0)
			{%>
				<td>
				<a href="/findShoeByID">
				<input type="submit" value="Buy Now"/>
				</a>
			</td>
			<%}
			%>
			<input type="hidden" name="passShoeID" id="passShoeID" value="<%=shoeID%>">
			<% 
			log.info( "ShoeID value:-" + shoeID);
			log.info( "passShoeID value:-" + request.getParameter("passShoeID")); %>			
			</tr>
			</form>
			<%}%>
			
		</table>
		<% }
		else
		{%>
			<h3>No Records Found.</h3>		
		<%
		}
		%>
</body>
</html>