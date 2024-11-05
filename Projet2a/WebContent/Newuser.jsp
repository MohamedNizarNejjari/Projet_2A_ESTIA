<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Ajouter un nouveau utlisateur</h1>
<form action="NewuserControleur" method="post">
	nom : <input type="text" name="nom" /> <br />
	prenom : <input type="text" name="prenom" /> <br />
	fonction : <input type="text" name="fonction" /> <br />
	password : <input type="password" name="password" /> <br />			
	<input type="submit" name="action" value="créer"/>
</form>
<c:if test="${not empty param.action and param.action eq 'créer'}">
    <c:redirect url="CompteControleur"/>
</c:if>
</body>
</html>