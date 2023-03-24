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
<%List<Admin> e=(List<Admin>)request.getAttribute("list"); %>

<table border="1">
<tr><th>AdminId</th><th>Adminname</th><th>AdminEmail</th></tr>

<%for(Admin es:e)
{
	%><tr><td><%=es.getAdminID() 
	%></td><td><%=es.getAdminName()
	%></td><td><%=es.getAdminEmail()
	%></td></tr>
    <%}%>
</table>


</body>
</html>