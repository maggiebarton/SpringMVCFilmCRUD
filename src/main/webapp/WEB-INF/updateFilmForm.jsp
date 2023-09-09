<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Details</title>
</head>
<body>
	<h1>Spring MVC Film Site</h1>
	<h3>Update Film:</h3>
	<form action="updateFilm.do" method="post">
		<input type="hidden" name="filmId" value="${film.filmId}">
		Title:
		<input type="text" name="title" value="${film.title}">
		<br>
		Description:
		<input type="text" name="description" value="${film.description}">
		<br>
		Release Year:
		<input type="number" name="releaseYear" value="${film.releaseYear}">
		<br>
		Language ID:
		<input type="number" name="langId" value="${film.langId}">
		<br>
		Rental Duration:
		<input type="number" name="rentDur" value="${film.rentDur}">
		<br>
		Rental Rate:
		<input type="number" name="rate" value="${film.rate}">
		<br>
		Length of Movie:
		<input type="number" name="length" value="${film.length}">
		<br>
		Replacement Cost:
		<input type="number" name="repCost" value="${film.repCost}">
		<br>
		Movie Rating:
		<input type="text" name="rating" value="${film.rating}">
		<br>
		Special Features:
		<input type="text" name="features" value="${film.features}">
		<br>
		<input type="submit" value="Submit">
		<input type="reset" value="Reset">
	</form>



</body>
</html>