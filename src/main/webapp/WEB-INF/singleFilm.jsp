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



	<h2>${films}</h2>

	<c:choose>
		<c:when test="${empty film}">

			<p>No films matched your search.</p>
			<p>
				<a href="index.html" class="btn btn-secondary" role="button">Back
					to Search</a>
			</p>


		</c:when>

		<c:otherwise>
					${film.filmId}
					${film.title}
					${film.description}
			
		</c:otherwise>

	</c:choose>
</body>
</html>