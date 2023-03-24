<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
label {
width:120px;
display:inline-block;
text-align: right;
}
.vertical-center {
  margin-left: 100px;
  margin-top:5px;
}
</style>
</head>
<body>
<form action="/addCustomer" id="addCustform" target="_top">
<br>
  <label for="custName">Customer name:</label>
  <input type="text" id="custName" name="custName"><br><br>
  
  <label for="custPrice">Email:</label>
  <input type="email" id="custEmail" name="custEmail"><br><br>
  
  <label for="custPass">Password:</label>
  <input type="password" id="custPass" name="custPass" min="0"><br><br>
  
  <div class="vertical-center"><input type="submit" value="Submit" form="addCustform"></div>
</form>
</body>
</html>