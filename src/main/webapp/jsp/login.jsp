<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineBankingSystem Login</title>
</head>
<body>
	<h2>Sign In</h2>

	<form:form method="post" modelAttribute="login" action="login">
		<spring:message code="login.username"></spring:message>
		<form:input path="username" />
		<form:errors path="username"></form:errors>
		<br>
		<spring:message code="login.password"></spring:message>
		<form:password path="password" />
		<form:errors path="password"></form:errors>
		<br>
		<input type="submit" value="Sign In" />
		<br />
	</form:form>
</body>
</html>