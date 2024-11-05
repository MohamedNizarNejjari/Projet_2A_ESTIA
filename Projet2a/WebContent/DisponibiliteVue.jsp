<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Renseignement des disponibilités</title>
</head>
<body>
<nav>
     <ul>
         <li><a href="DisponibiliteControleur">Disponibilité</a></li>
         <li><a href="AppareilControleur">Appareils</a></li>
         <li><a href="BrancheControleur">Apprareils Branchées</a></li>
         <li><a href="BilanControleur">Bilan</a></li>
        </ul>
</nav>

<h1>Renseignement des disponibilités</h1>
<div class="zbi">
		<table border="1">
			<tr>
				<th>Date</th>
				<th>Jour</th>
				<th>Heure de recharges éventuelles</th>
			</tr>
			<c:forEach items="${disponibiliteListe}" var="disponibilite">
				<tr>
					<td><c:out value="${disponibilite.date}" /> </td>
					<td><c:out value="${disponibilite.jour}" /> </td>
					<td><c:out value="${disponibilite.hre}" /> </td>
				</tr>
			</c:forEach>
		</table>
</div>
<h2>Ajouter une nouvelle appareil</h2>
		<form action="DisponibiliteControleur" method="post">
			date : <input type="text" name="date" /> <br />
			jour : <input type="text" name="jour" /> <br />
			Heure de recharges éventuelles : <input type="text" name="hre" /> <br />	
			<input type="submit" value="Ajouter" />
		</form>
      <ul>
        <li><a href="AppareilControleur">Confirmer</a></li>
        <li><a href="CompteControleur">Connexion</a></li>
    </ul>
</body>
</html>
