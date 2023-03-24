<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  <h1>Page to be displayed when Admin Clicks on 'Search Shoe'</h1>-->
<form action="getShoeByname" id="searchShoeForm">

  <label for="shoeName">Shoe name:</label>
  <input type="text" id="shoeName" name="shoeName"><br><br>
  
  <input type="submit" value="Search" form="searchShoeForm">
</form>
</body>
</html>