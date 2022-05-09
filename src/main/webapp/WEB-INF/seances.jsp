<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seances</title>
</head>
<body>
<h1>Séance et Salles</h1>
<h2>Bienvenue dans notre site de réservation de places</h2>
<table  border="1" cellpadding="0" cellspacing="0"
      style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
    <thead>
        <tr bgcolor="#000FFF">
            <th colspan="5">Vous trouvez ci-dessous la liste des séances disponibles pour la réservation.</br> Merci de réserver vos places.</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>N° Séance</td>
            <td>Horaire</td>
            <td>Tarif</td>
            <td>Places</td>
        </tr>
        
        <c:forEach var="c" items="${listeSeances}" >
  <tr>
      <td ><c:out value="${c.id}"/></td>
      <td ><c:out value="${c.horaire}"/></td>
      <td ><c:out value="${c.tarif}"/></td>
      <td ><c:out value="${c.places}"/></td>
      <td align="center">
        <form method="GET" action="reservation">
      <input type="submit" value="Reserver" name="Reserver" >
      </form>
      </td>
  </tr>
     </c:forEach>
    </tbody>

</table>

</body>
</html>