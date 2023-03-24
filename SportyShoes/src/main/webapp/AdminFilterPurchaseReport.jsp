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
<%List<Orders> e=(List<Orders>)request.getAttribute("list"); %>
<%if(e != null && e.size() > 0)
	{%>
	    <form action="/getFilteredOrders">
	    <div name="frame_top">
	    	<label for="From_Date">From Date:</label>
	   		<input type="date" id="From_Date" name="From_Date"><br><br>
	     	<label for="To_Date">To Date:</label>
	    	<input type="date" id="To_Date" name="To_Date"><br><br>
			
			 <input type="submit" value="Submit" />
	    </div>
	    </form>
	    <div name="div_bottom" >
	    		<% Logger log = Logger.getAnonymousLogger(); %>
			<table border="1">
			<tr><th>Order ID</th><th>Customer Name</th><th> Shoe Name</th><th> Price</th><th> Quantity</th><th> Total Amount Paid</th><th> Purchase Date</th></tr>
			<h2><i>List of Orders</i></h2>
			<%for(Orders es:e)
			{%>
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
	    </div>	
		<% }
		else
		{%>
			<h3>No Records Found.</h3>		
		<%
		}
		%>
</body>
</html>