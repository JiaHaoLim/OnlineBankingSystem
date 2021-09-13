<%@page import="com.onlinebankingsystem.service.UserService"%>
<%@page import="com.onlinebankingsystem.controller.UserController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineBankingSystem Unlock</title>
</head>
<body>
	<h2>Unlock Account</h2>
	<h3>Your account has been locked for having <%=UserService.MAX_FAILED_ATTEMPTS%> or more failed login attempts.</h3>
	<h3>Please answer your secret question.</h3>
	
	Your secret question: ${secret.username} <br>

	<form:form method="post" modelAttribute="<%=UserController.MODEL_ATTRIBUTE_SECRET%>" action="unlockaccount">
		<spring:message code="secret.password"></spring:message>
		<form:input path="password" />
		<form:errors path="password"></form:errors>
		<br>
		<input type="submit" value="Unlock Account" />
		<br />
	</form:form>
</body>
</html>