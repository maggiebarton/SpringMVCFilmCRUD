<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Details</title>
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
			<h1 class="display-5">Update Actor</h1>
		</div>
	</div>

	<div class="container">
		<div class="row align-items-center">
			<div class="col">
				<form action="updateActor.do" method="post">
					<input type="hidden" name="actorId" value="${actor.actorId}">

					<div class="mb-3">
						<label for="firstName" class="form-label">First Name</label> <input
							type="text" name="firstName" value="${actor.firstName}"
							class="form-control">
					</div>

					<div class="mb-3">
						<label for="laststName" class="form-label">Last Name</label> <input
							type="text" name="lastName" value="${actor.lastName}"
							class="form-control">
					</div>
					<div class="mb-3">
						<input type="submit" class="btn btn-secondary" role="button"
							value="Submit"> <input type="reset"
							class="btn btn-outline-secondary" role="button" value="Reset">
					</div>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>

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