<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action= "editTeamServlet" method="post">
Team: <input type ="text"name = "name"value= "${teamToEdit.store}">
Number Of Players: <input type = "text"name = "numOfPlayers"value= "${teamToEdit.item}">
<input type = "hidden"name = "id"value="${teamToEdit.id}">
<input type = "submit"value="Save Edited Team">
</form>
</body>
</html>