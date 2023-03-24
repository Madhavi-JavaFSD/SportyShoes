<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Shoe</title>
<style>
h1 {
  text-align: center;
}
label {
width:240px;
display:inline-block;
text-align: right;
}
.vertical-center {
  margin-left: 250px;
  margin-top:5px;
}
</style>
</head>
<body>
<h2>Enter details for the new shoe you would like to add:-</h2>
<form action="addShoe" id="addform">
  <label for="shoeName">Shoe name:</label>
  <input type="text" id="shoeName" name="shoeName"><br><br>
  
  <label for="shoePrice">Shoe Price:</label>
  <input type="number" id="shoePrice" name="shoePrice"><br><br>
  
  <label for="shoeQuantity">Shoe Quantity:</label>
  <input type="number" id="shoeQuantity" name="shoeQuantity" min="0"><br><br>
  
 <div class="vertical-center"><input type="submit" value="Submit" form="addform" value="addShoe"></div>
</form>


</body>
</html>