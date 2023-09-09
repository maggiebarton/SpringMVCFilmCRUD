<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actor Details</title>
</head>
<body>
	<h1>Spring MVC Film Site</h1>
	<h3>Update Actor:</h3>
	<form action="updateActor.do" method="post">
		<input type="hidden" name="actorId" value="${actor.actorId}">
		First Name:
		<input type="text" name="firstName" value="${actor.firstName}">
		<br>
		Last Name:
		<input type="text" name="lastName" value="${actor.lastName}">
		<br>
		<input type="submit" value="Submit">
		<input type="reset" value="Reset">
	</form>



</body>
</html>