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


	<h1>Film Details</h1>


	<c:choose>
		<c:when test="${empty film}">
			<p>No films matched your search.</p>
			<p>
				<a href="index.html" class="btn btn-secondary" role="button">Back
					to Home</a>
			</p>

		</c:when>
		<c:otherwise>
					${film.filmId}
					${film.title}
					${film.description}
					${film.releaseYear}
					${film.langId}
					${film.rentDur}
					${film.rate}
					${film.length}
					${film.repCost}
					${film.rating}
					${film.features}
					${film.category}<br>
					${film.actors}
				
					
			
		</c:otherwise>
	</c:choose>
		<a href="updateFilmForm.do?filmId=${film.filmId}">Update Film</a>

		<a href="addFilm.html">Delete Film</a>
	
</body>
</html>