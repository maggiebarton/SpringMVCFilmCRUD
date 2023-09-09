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
		<c:when test="${empty films}">

			<p>No films matched your search.</p>
			<p>
				<a href="index.html" class="btn btn-secondary" role="button">Back
					to Search</a>
			</p>


		</c:when>

		<c:when test="${not empty films}">

			<ul>

				<c:forEach var="film" items="${films}">
					<li>
					<a href="getFilm.do?filmId=<c:out value="${film.filmId}"/>">${film.title}</a></li>
				</c:forEach>
			</ul>

		</c:when>

	</c:choose>
</body>
</html>