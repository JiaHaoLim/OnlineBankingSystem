<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>FundTransfer</h1><br>
		<h2>Enter Account number</h2>
		<form method="post" action ="transfer"> 
		Account number: <input type ="number" name = "account_number"><br> 
		Fund to transfer: <input type ="number" step = "0.01" name = "acc_balance"><br>
		<h2>select funds to transfer to </h2>
		Account number:<input type ="number" name = "account_number"><br>
		<input type = "submit" value= "Transfer fund"></button>
	</form>
</body>
</html>