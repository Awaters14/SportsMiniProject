<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="addGameServlet">
	<table>
		<tr>
			<td><input type="date" name="date" required></td>
			<td><input type="time" name="time" required></td>
			<td>
				<table>
					<tr>Away Team</tr>
					<c:forEach items = "${requestScope.allTeams}" var="currentTeams">
						<tr>
							<td><input type="radio" name="away" value="${currentTeams.id}" required></td>
							<td>${currentTeams.name}</td>
							<td>${currentTeams.numOfPlayers}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
			<td>
				<table>
					<tr>Home Team</tr>
					<c:forEach items = "${requestScope.allTeams}" var="currentTeams">
						<tr>
							<td><input type="radio" name="home" value="${currentTeams.id}" required></td>
							<td>${currentTeams.name}</td>
							<td>${currentTeams.numOfPlayers}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
			<td><input type="submit" value="Add Game"></td>
		</tr>
	</table>
</form>
</body>
</html>