<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sports Mini Project - Game List</title>
</head>
<body>
	<form method="post" action="gameServlet">
	<table>
		<c:forEach items="${requestScope.listGames}" var="currentGame">
			<tr>
				<td><input type="radio" name="game" value="${currentGame.id}"></td>
				<td>${currentGame.date}</td>
				<td>${currentGame.time}</td>
				<td>${currentGame.away.name}</td>
				<td> @ </td>
				<td>${currentGame.home.name}</td>
				
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Delete" name="doThisToItem">
	<input type="submit" value="Add a Team" name="doThisToItem">
	<input type="submit" value="Add a Game" name="doThisToItem">
	</form>
	<form action="viewAllTeamsServlet">
		<input type="submit" value="View All Teams">
	</form>
	<form action="viewGamesServlet">
		<input type="submit" value="View All Games"> <br/>
	</form>
	<p>${result }</p>
</body>
</html>