<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sports Mini Project - Team List</title>
</head>
<body>
	<form method="post" action="menuServlet">
	<table>
		<c:forEach items = "${requestScope.allTeams}" var="currentTeams">
			<tr>
				<td><input type="radio" name="team" value="${currentTeams.id}"></td>
				<td>${currentTeams.name}</td>
				<td>${currentTeams.numOfPlayers}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value = "Edit" name="doThisToItem">
	<input type="submit" value = "Delete" name="doThisToItem">
	<input type="submit" value = "Add" name="doThisToItem">
	</form>
</body>
</html>