<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineBankingSystem Home</title>
</head>
<body>
	<h2>Login Success!</h2>
	
	In a complete breach of security and privacy, here are all your details: <br>
	ID: ${user.id} <br>
	Name: ${user.name} <br>
	Login Username: ${user.loginUsername} <br>
	Login Password: ${user.loginPassword} <br> 
	Secret Question: ${user.secretQuestion} <br>
	Secret Answer: ${user.secretAnswer} <br>
	Number of failed logins: ${user.numFailedLogins} <br>
	Lock Status: ${user.isLocked} <br>
</body>
</html>