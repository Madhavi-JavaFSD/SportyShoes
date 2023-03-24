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
<%List<Orders> e=(List<Orders>)request.getAttribute("filteredList"); %>
<%if(e != null && e.size() > 0)
	{
	
		 Logger log = Logger.getAnonymousLogger(); %>
		<table border="1">
		<tr><th>Order ID</th><th>Customer Name</th><th> Shoe Name</th><th> Price</th><th> Quantity</th><th> Total Amount Paid</th><th> Purchase Date</th></tr>
		<h2><i>List of Orders within selected date range</i></h2>
		<%for(Orders es:e){%>
			<%int orderID = es.getOrderID();%>
			<tr>
			<td><%=es.getOrderID()%></td>
			<td><%=es.getCustRef().getCustName()%></td>
			<td><%=es.getShoeRef().getShoeName()%></td>
			<td><%=es.getShoePrice()%></td>
			<td><%=es.getOrderQuantity()%></td>
			<td><%=es.getTotalAmountPaid()%></td>
			<td><%=es.getPurchaseDate()%></td>		
			</tr>
			<%}%>
			
		</table>
		<% }
		else
		{%>
			<h3>No Purchase orders in the specified date range.</h3>		
		<%
		}
		%>
</body>
</html>