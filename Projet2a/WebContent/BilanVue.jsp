<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bilan</title>
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
<h1>Bilan</h1>
<div class="zbi">
    <c:set var="totalEnergy" value="0.0" />
    <table border="1">
        <tr>
            <th>Liste des appareils</th>
            <th>Consommation des appareils</th>
        </tr>
        <c:forEach items="${appareilListe}" var="appareil">
            <tr>
                <td><c:out value="${appareil.nom}" /></td>
                <td><c:out value="${appareil.puissance * appareil.dureeutilisation / 1000.0}" /></td>
            </tr>
            <c:set var="totalEnergy" value="${totalEnergy + (appareil.puissance * appareil.dureeutilisation / 1000.0)}" />
        </c:forEach>
        <tr>
            <td>Total Energie:</td>
            <td><c:out value="${totalEnergy}" /></td>
        </tr>
    </table>
</div>
<ul>
   <li><a href="CompteControleur">Se déconnecter</a></li>
</ul>
</body>
</html>