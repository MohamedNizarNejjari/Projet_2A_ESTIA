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
    <h1 style="text-align:center">ECO-SMART</h1>
    <form action="CompteControleur"  method="post">
        <label for="username">Username:</label>
        <input type="text" id="utilisateur_id" name="nom">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br>
        <input type="submit" value="Login">
    </form>
    
     <ul>
        <li><a href="NewuserControleur">Créer un compte</a></li>
    </ul>


</body>
</html>