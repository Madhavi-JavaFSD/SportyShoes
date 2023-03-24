<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  <h1>Page to be displayed when Admin Clicks on 'Search Customer'</h1>-->
<form action="getCustomerByname" id="searchCustomerForm">

  <label for="customerName">Customer name:</label>
  <input type="text" id="customerName" name="customerName"><br><br>
  
  <input type="submit" value="Search" form="searchCustomerForm">
</form>
</body>
</html>