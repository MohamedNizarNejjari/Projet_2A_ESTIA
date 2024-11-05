<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appareils Branchés</title>
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
	<h1>Appareils branchés</h1>
		<table border="1">
			<tr>
				<th>Liste des appareils</th>
				<th>Niveau de la batterie</th>
				<th>Durée d'utilisation</th>
			</tr>
			<c:forEach items="${appareilListe}" var="appareil">
				<tr>
					<td><c:out value="${appareil.nom}" /></td>
					<td><c:out value="${appareil.niveaubatterie}" /></td>
					<td><c:out value="${appareil.dureeutilisation}" /></td>
				</tr>
			</c:forEach>
		</table>

		<form action="BrancheControleur" method="post">
			<table style="background-color: white;">
				<tr>
					<td style="border: 2px solid white;">Branché un apprareil:</td>
					<td style="border: 2px solid white;">
					<select name="nomAppareilBranche">
							<option>--Appareil à recharger--</option>
							<c:forEach items="${tousAppareilListe}" var="leAppareil">
								<option value="${leAppareil.nom}"> 
									<c:out value="${leAppareil.nom}" /> 
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td style="border: 2px solid white;"></td>
					<td style="border: 2px solid white;">
					<input type="submit"
						value="Brancher" style="float: right;">
					</td>
				</tr>
			</table>
		</form>
<ul>
   <li><a href="StrategieControleur">Stratégies</a></li>
</ul>
</body>
</html>
