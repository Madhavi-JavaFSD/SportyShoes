<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Page to show Admin when she successfully completes transaction-->
<h3>You have successfully purchased the below show:-</h3>
<%= request.getAttribute("ShoePurchased") %>
</body>
</html>