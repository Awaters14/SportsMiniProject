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
<table>
<c:forEach items = "${requestScope.allTeams}" var="currentTeams">
	<tr>
		<td><input type="radio"name="id"value="${currentTeams.id}"></td>
		<td>${currentTeams.name}</td>
		<td>${currentTeams.numOfPlayers}</td>
		</tr>
	</c:forEach>
</table>
<input type = "submit"value = "edit"name="doThisToItem">
<input type = "submit"value = "delete"name="doThisToItem">
<input type="submit"value = "add"name = "doThisToItem">
</body>
</html>