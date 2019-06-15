<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I tuoi annunci</title>
</head>
<body>
<div class="container">

	<%@ include file="../header.jsp" %>

  	<div class="page-header">
	  <h3>Hai ${listaAnnunciAttribute.size()} annunci: </h3>
	</div>
  	
<table class="table table-striped">
		<thead>
			<tr>
				<th>Annuncio</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<c:forEach items="${listaAnnunciAttribute}" var="annuncioItem">
			<tr>
				<td>${annuncioItem.testoAnnuncio}</td>
				<td>
					<a href="${pageContext.request.contextPath}/utente/VisualizzaDettaglioAnnuncioUtenteServlet?idAnnuncio=${annuncioItem.id}" class="btn btn-info">Dettaglio</a>
					<c:if test="${annuncioItem.aperto}">
					<a href="${pageContext.request.contextPath}/utente/PrepareModificaAnnuncioUtenteServlet?idAnnuncio=${annuncioItem.id}" class="btn btn-info">Modifica</a>
					<a href="${pageContext.request.contextPath}/utente/PrepareEliminaAnnuncioUtenteServlet?idAnnuncio=${annuncioItem.id}" class="btn btn-info">Rimuovi</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<a href="${pageContext.request.contextPath}/utente/PrepareInserisciAnnuncioUtenteServlet" class="btn btn-primary btn-md">Inserisci nuovo Annuncio</a>
<%-- 		<c:forEach items="${listalista}" var="listaI"> --%>
<%-- 		<p>${listaI}</p> --%>
<%-- 				</c:forEach> --%>
		
			<tr>
<!-- 				<td> -->
<%-- 					<a href="VisualizzaDettaglioContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Dettaglio</a> --%>
<%-- 					<a href="PrepareModificaContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Modifica</a> --%>
<%-- 					<a href="PrepareEliminaContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Elimina</a> --%>
<!-- 				</td> -->
			</tr>
				
	</table>
</div>
</body>
</html>



