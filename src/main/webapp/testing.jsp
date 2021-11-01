<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Item &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Quantity
	<form action="UserServlet">
	
		<input type="checkbox" name="chboxsoap">Soap &nbsp;&nbsp;&nbsp;<input type="text" name="txtsoapqty"><br>
		<input type="checkbox" name="chboxchoc">Chocolate &nbsp;&nbsp;&nbsp;<input type="text" name="txtChocqty"><br>
		<input type="checkbox" name="chboxchips">Chips &nbsp;&nbsp;&nbsp;<input type="text" name="txtChipsqty"><br>
		<input type="checkbox" name="chboxShampoo">Shampoo &nbsp;&nbsp;&nbsp;<input type="text" name="txtShampooqty"><br>
		<input type="checkbox" name="chboxmilkpwdr">Milk Powder &nbsp;&nbsp;&nbsp;<input type="text" name="txtMilkpwdrqty"><br>
		<input type="submit" value="Calculate Bill">
		
	</form>
</body>
</html>