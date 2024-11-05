<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! String HRE = "16:30:00" ;  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav>
     <ul>
         <li><a href="DisponibiliteControleur">Disponibilité</a></li>
         <li><a href="AppareilControleur">Appareils</a></li>
         <li><a href="BrancheControleur">Apprareils Branchées</a></li>
        </ul>
</nav>
<h1>ECO-SMART</h1>
<p>Information Check</p>
<div class="zbi">
		<table border="1">
			<tr>
				<th>Heures éventuelles choisis</th>	
				<th>Disponibilites</th>		
			</tr>
			<c:forEach items="${disponibiliteListe}" var="disponibilite">
				<tr>
					<td><c:out value="${disponibilite.hre}" /> </td>
					<td><c:if test="${disponibilite.hre == '10:30:00 à 12:30:00'}">
					   La charge est disponible
					   </c:if>
					   <c:if test="${disponibilite.hre != '10:30:00 à 12:30:00'}">
					       La charge est indisponible
					       </c:if>
					   </td>
				</tr>
			</c:forEach>
		<table border="1">
			<tr>
				<th>Liste des appareils branchés</th>
			</tr>
			<c:forEach items="${brancheListe}" var="branche">
				<tr>
					<td><c:out value="${branche.nom}" /></td>
				</tr>
			</c:forEach>
		</table>		
</div>	
<ul>
   <li><a href="BilanControleur">Bilan des appareils</a></li>
</ul>
</body>
</html>