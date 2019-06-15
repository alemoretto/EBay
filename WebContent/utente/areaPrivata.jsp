<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Cartella Esattoriale</title>
</head>
<body>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio dell'Utente:
				${utenteDTOAttribute.username}</h3>
		</div>
		<br>
		<div class="container-fluid" id="idContainer">

			<dl class="row">
	<dt class="col-sm-3 text-right">Nome</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.nome}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Cognome</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.cognome}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Username</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.username}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Password</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.password}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Credito</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.credito}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Ruolo</dt>
	<dd class="col-sm-9">
		<c:forEach items="${utenteDTOAttribute.ruoli}" var="ruolo"
			varStatus="loop">
				${ruolo.descrizione} 
				<c:if test="${utenteDTOAttribute.ruoli.size()-1 > loop.index}">, </c:if>
		</c:forEach>
	</dd>
</dl>
<dl class="row">
	<dt class="col-sm-3 text-right">Registrato il</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.dataRegistrazione}</dd>
</dl>
		
		<a	href="${pageContext.request.contextPath}/utente/ExecuteStoricoAcquistoServlet?idUtente=${utenteDTOAttribute.id}"
				class="btn btn-primary btn-md">Storico Acquisti</a>
		<a	href="${pageContext.request.contextPath}/utente/ExecuteRicercaAnnuncioUtenteServlet?idUtente=${utenteDTOAttribute.id}"
				class="btn btn-primary btn-md">I tuoi annunci</a>
			
		</div>
	</div>


</body>
</html>
