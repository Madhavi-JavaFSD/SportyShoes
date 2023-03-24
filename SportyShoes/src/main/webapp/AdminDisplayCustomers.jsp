<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.example.demo.model.*" %>
    <%@page import="java.util.*" %>
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
<!-- Page to show Admin when she clicks on 'Show All Customers'-->
<%List<Customer> e=(List<Customer>)request.getAttribute("list"); %>
<%if(e != null && e.size() > 0)
	{%>
	
		<h1><i>List of Customers</i></h1>
		<table border="1">
		<tr><th>Customer ID</th><th>Name</th><th>Email</th></tr>
		<%for(Customer es:e){%>
		<tr>
		<td><%=es.getCustID() %></td>
		<td><%=es.getCustName()%></td>
		<td><%=es.getCustEmail()%></td>
		</tr>
			<%}%>
		</table>
	<%}
else{%>
	<h3>No Records Found.</h3>		
    <%}%>

</body>
</html>