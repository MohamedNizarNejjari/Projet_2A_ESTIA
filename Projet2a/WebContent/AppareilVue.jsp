<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appareils à recharger </title>
<style>
</style>
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
<h1>Appareils à recharger</h1>
<div class="zbi">
		<table border="1">
			<tr>
				<th>Liste des appareils</th>
				<th>Nombre</th>
				<th>Puissance</th>
				<th>Niveau de la batterie</th>
				
			</tr>
			<c:forEach items="${appareilListe}" var="appareil">
				<tr>
					<td><c:out value="${appareil.nom}" /> </td>
					<td><c:out value="${appareil.nombre}" /> </td>
					<td><c:out value="${appareil.puissance}" /> </td>	
					<td><c:out value="${appareil.niveaubatterie}" /> </td>
				</tr>
			</c:forEach>
		</table>
</div>
		<h2>Ajouter une nouvelle appareil</h2>
		<form action="AppareilControleur" method="post">
			nom : <input type="text" name="nom" /> <br />
			nombre : <input type="text" name="nombre" /> <br />
			puissance : <input type="text" name="puissance" /> <br />
			niveau de batterie : <input type="text" name="niveaubatterie" /> <br />	
			durée d'utilisation : <input type="text" name="dureeutilisation" /> <br />	
			<input type="submit" value="Ajouter" />
		</form>
<div style="float: left; width: 30%;">
	<h3>Supprimer une appareil</h3>
	<form action="AppareilSupprimerControleur" method="post">
		nom : <input type="text" name="nom" /> <br />
		<p>
			<input type="submit" value="Retirer"/>
		</p>
	</form>
</div>
<ul>
   <li><a href="BrancheControleur">Les appareils à branché</a></li>
</ul>
</body>
</html>