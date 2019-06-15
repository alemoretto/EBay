<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Utenti</title>
</head>
<body>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>La ricerca ha prodotto ${listaUtentiAttributeName.size()}  risultati: </h3>
	</div>
  	
<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Action</th>
			</tr>
		</thead>
			<c:forEach items="${listaUtentiAttributeName}" var="utenteItem">
			<tr>
				<td>${utenteItem.nome}</td>
				<td>${utenteItem.cognome}</td>
				<td>
					<a href="${pageContext.request.contextPath}/admin/VisualizzaDettaglioUtenteServlet?idUtente=${utenteItem.id}" class="btn btn-info">Dettaglio</a>
					<a href="${pageContext.request.contextPath}/admin/PrepareModificaUtenteServlet?idUtente=${utenteItem.id}" class="btn btn-info">Modifica</a>
					<a href="${pageContext.request.contextPath}/admin/PrepareEliminaUtenteServlet?idUtente=${utenteItem.id}" class="btn btn-info">Elimina</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
</div>
</body>
</html>



