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
 <script language="javascript" type="text/javascript">
function editShoefn() {
	
   // location.href = '@Url.Action("/updateShoe","ShoeController")';
   // location.href = "<c:url value="/updateShoe"/>
}
</script>
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
		<tr><th>Shoe ID</th><th>Shoe Name</th><th> Price</th><th> Quantity</th><th> Edit</th></tr>
		<h1><i>List of Shoes</i></h1>
		<%for(Shoe es:e){%>
			<%int shoeID = es.getShoeID();%>
			<form action="/editShoe">
			<tr>
			<td><%=shoeID%></td>
			<td><%=es.getShoeName()%></td>
			<td><%=es.getShoePrice()%></td>
			<td><%=es.getShoeQuantity()%></td>
			
			
			<!-- <td><a href="AdminEditShoe.jsp?shoeID=<%=shoeID%>">Edit</a></td>-->
			<td>
			<a href="/editShoe">
			 <input type="submit" value="Edit Shoe" />
			</a>
			</td>
			
			<!-- Commenting the Delete Shoe button because deleting a shoe entry violates the foreign key constraint.
			Once a shoe entry has been created and an order has been placed, it is not correct to delete the
			shoe entry
			<td>
			<a href="/deleteShoe">
			 <input type="submit" value="Delete Shoe" />
			</a>
			</td>-->
			
			<!-- <td><Input type="submit" value ="Delete" onclick="location.href='/deleteShoe'"></td>-->
			
			<!-- 
			<td><input type="submit" value ="Edit" onclick="location.href='/updateShoe?id=${ed.getShoeID()}'" /></td>
			<td><Input type="submit" value ="Delete" onclick="location.href='/deleteShoe'"></td>
			-->
			
			
			
			<input type="hidden" name="passShoeID" id="passShoeID" value="<%=shoeID%>">
			<% 
			log.info( "ShoeID value:-" + shoeID);
			log.info( "passShoeID value:-" + request.getParameter("passShoeID")); %>
		
			<!--<td><input type="button" value ="Edit" onclick="location.href='@Url.Action("updateShoe", "ShoeController")'" /></td>
			<td><Input type="button" value ="Delete" onclick="deleteShoe"></td>
			 <td><a href="AdminEditShoe.jsp?id=<%=es.getShoeID()%>">Edit Shoe</a></td>
			<td><a href="AdminDeleteShoe.jsp?id=<%=es.getShoeID()%>">Delete Shoe</a></td>-->
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