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


	<h1>Update Status</h1>

	<c:choose>
		<c:when test="${empty film}">
			<p>An error occurred while updating film.</p>
			<p>
				<a href="index.html" class="btn btn-secondary" role="button">Back
					to Home</a>
			</p>

		</c:when>
		<c:otherwise>
			<p>Update Successful! See details...</p>
					${film.filmId}
					${film.title}
					${film.description}
					
			<p>
				<a href="index.html" class="btn btn-secondary" role="button">Back
					to Home</a>
			</p>

		</c:otherwise>
	</c:choose>
</body>
</html>