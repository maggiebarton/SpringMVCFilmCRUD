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


	<h1>Actor Details</h1>


	<c:choose>
		<c:when test="${empty actor}">
			<p>Error adding actor.</p>
			<p>
				<a href="index.html" class="btn btn-secondary" role="button">Back
					to Home</a>
			</p>

		</c:when>
		<c:otherwise>
		<p>Actor added! See details...</p>
					${actor.actorId}
					${actor.firstName}
					${actor.lastName}
					
				
					
		<a href="updateActorForm.do?actorId=${actor.actorId}">Update Actor</a>

		<a href="deleteActor.do?actorId=${actor.actorId}">Delete Actor</a>
		
		<a href="index.html" class="btn btn-secondary" role="button">Back to Home</a>

		
			
		</c:otherwise>
	</c:choose>
	
</body>
</html>