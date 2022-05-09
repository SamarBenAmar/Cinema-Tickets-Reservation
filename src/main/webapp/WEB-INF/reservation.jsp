<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation</title>
</head>
<body>
<h1>Réservation</h1>
<h2>Bienvenue dans notre site de réservation de places</h2>
<h5>Connectez-vous pour pouvoir compléter la réservation de vos places</h5>
<c:if test="${!empty session.seanceSelectionnee }"><p>${session.seanceSelectionnee}</p></c:if>
<c:if test="${!empty form.resultat }"><p><c:out value="${form.resultat }"/></p></c:if>
<form method="post" action="reservation">
Login: <input type="text" placeholder="Enter Login" name="user_id" required><br><br>
Password: <input type="password" placeholder="Enter Password" name="password" required><br><br>
<input type="submit" value="Reserver" name="finaliser" required>
</form>

</body>
</html>