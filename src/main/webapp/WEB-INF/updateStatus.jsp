<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Status</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body style="padding-bottom: 70px">

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.html"> <img
				src="images/filmLogoWhite.png" alt="Logo" width="32" height="30"
				class="d-inline-block align-text-top"> <em>Spring MVC
					Film CRUD</em>
			</a>
		</div>
	</nav>
	<div class="row text-center">
		<div class="p-3 mb-2 bg-secondary text-white">
			<h1 class="display-2">Update Status</h1>
		</div>
	</div>

	<c:choose>
		<c:when test="${empty film}">
			<div class="container">
				<div class="row align-items-center">
					<p class="lead">An error occurred while updating film.</p>

					<br> <a href="index.html" class="btn btn-secondary"
						role="button">Back to Home</a>

				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div class="row">
					<div class="col">
						<p class="lead">Update Successful! See details...</p>
						<dl class="row">
							<dt class="col-sm-3">ID</dt>
							<dd class="col-sm-9">${film.filmId}</dd>

							<dt class="col-sm-3">Title</dt>
							<dd class="col-sm-9">${film.title}</dd>

							<dt class="col-sm-3">Description</dt>
							<dd class="col-sm-9">${film.description}</dd>

							<dt class="col-sm-3">Release Year</dt>
							<dd class="col-sm-9">${film.releaseYear}</dd>

							<dt class="col-sm-3">Language ID</dt>
							<dd class="col-sm-9">${film.langId}</dd>

							<dt class="col-sm-3">Rental Duration</dt>
							<dd class="col-sm-9">${film.rentDur}</dd>

							<dt class="col-sm-3">Rental Rate</dt>
							<dd class="col-sm-9">${film.rate}</dd>

							<dt class="col-sm-3">Length</dt>
							<dd class="col-sm-9">${film.length}</dd>

							<dt class="col-sm-3">Replacement Cost</dt>
							<dd class="col-sm-9">${film.repCost}</dd>

							<dt class="col-sm-3">Rating</dt>
							<dd class="col-sm-9">${film.rating}</dd>

							<dt class="col-sm-3">Special Features</dt>
							<dd class="col-sm-9">${film.features}</dd>

							<dt class="col-sm-3">Category</dt>
							<dd class="col-sm-9">${film.category}</dd>

							<dt class="col-sm-3">Actors</dt>
							<dd class="col-sm-9">
								<c:forEach var="actor" items="${film.actors}">
									<p>${actor}</p>
								</c:forEach>
							</dd>

						</dl>
					</div>
					<div class="col text-center">

						<a href="updateFilmForm.do?filmId=${film.filmId}"
							class="btn btn-outline-secondary" role="button">Update Film</a><br>
						<br> <a href="deleteFilm.do?filmId=${film.filmId}"
							class="btn btn-outline-secondary" role="button">Delete Film</a><br>
						<br> <a href="index.html" class="btn btn-secondary"
							role="button">Back to Home</a>

					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

	<footer class="fixed-bottom bg-dark text-center text-white">

		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			Made by: <a class="text-white" href="https://github.com/maggiebarton">Maggie</a>
			and <a class="text-white" href="https://github.com/ezhailion">Sawyer</a>
		</div>

	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>