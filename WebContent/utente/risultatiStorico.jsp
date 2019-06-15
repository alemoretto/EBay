<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati Storico</title>
</head>
<body>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<c:if test="${esitoAcquistoBool}">
			<div class="alert alert-success">
				${esitoAcquisto}</div>
	</c:if>
  	
  	<div class="page-header">
	  <h3>I tuoi acquisti passati: </h3>
	</div>
  	
<table class="table table-striped">
		<thead>
			<tr>
				<th>Descrizione</th>
				<th>Prezzo (euro)</th>
				<th>Anno</th>
			</tr>
		</thead>
			<c:forEach items="${storicoDTOAttribute}" var="acquistoItem">
			<tr>
			
				<td>${acquistoItem.descrizione}</td>
				<td>${acquistoItem.prezzo}</td>
				<td>${acquistoItem.anno}</td>

			</tr>
		</c:forEach>
	
	</table>
</div>
</body>
</html>



