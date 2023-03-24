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
  <script>
function checkValidationOfForm(){
let name=document.addCustform.custEmail.value;
console.log("the email value is "+email)
let pwd=document.addCustform.custPass.value;
console.log("the pwd value is "+pwd)


if(email==""){
  alert("email should not be empty")
}
else if(pwd==""){
  alert("password should not be empty")
}
</script>
</head>
<body>
<form action="/checkIfCustomer" id="addCustform" name ="addCustform" target="_top">
<br>
  <label for="custEmail" style="text-align:right;">Customer Email:</label>
  <input type="text" style="text-align:left;" id="custEmail" name="custEmail"><br><br>
    
  <label for="custQuantity" style="text-align:right;">Password:</label>
  <input type="password" style="text-align:left;" id="custPass" name="custPass" min="0"><br><br>
  
 <div class="vertical-center"><input type="submit" value="Submit" form="addCustform" onclick="checkValidationOfForm()"></div>
</form>
</body>
</html>