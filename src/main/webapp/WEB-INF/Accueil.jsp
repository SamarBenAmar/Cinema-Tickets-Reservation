<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
<h1>Cinéma</h1>
<h2>Bienvenue dans notre site de réservtion de places</h2>
<table  border="1" cellpadding="0" cellspacing="0"
      style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
    <thead>
        <tr bgcolor="#000FFF">
            <th colspan="2">Vous trouvez ci-dessous la liste des films disponibles. Merci de réserver vos places.</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>N° film</td>
            <td>Titre du film</td>
        </tr>
        
        <c:forEach var="c" items="${listeFilms}" >
  <tr>
      <td ><c:out value="${c.id}"/></td>
      <td ><c:out value="${c.name}"/></td>
      <td><c:out />  
      <form method="GET" action="seances">
      <input type="submit" value="seances" name="seances">
      </form>
      </td>
  </tr>
</c:forEach> 
    </tbody>
</table>

</body>
</html>