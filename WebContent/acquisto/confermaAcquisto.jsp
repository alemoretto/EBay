<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Annuncio</title>
</head>
<body>

	<div class="container">
		<%@ include file="../header.jsp"%>

	<c:if test="${esitoAcquistoBool != null && !esitoAcquistoBool}">
			<div class="alert alert-danger">
				${esitoAcquisto}</div>
	</c:if>
	
		<div class="page-header">
			<h3>Dettagli:</h3>
		</div>
		<br>
		<div class="container-fluid" id="idContainer">

			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${annuncioAttribute.testoAnnuncio} <br>
				(<c:forEach items="${annuncioAttribute.categorie}" var="categoria" varStatus="loop">
					${categoria.descrizione} 
				<c:if test="${annuncioAttribute.categorie.size() -1 > loop.index}">, </c:if>
		</c:forEach>)
		</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Prezzo(euro)</dt>
				<dd class="col-sm-9">${annuncioAttribute.prezzo}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Pubblicato il</dt>
				<dd class="col-sm-9">${annuncioAttribute.data}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">da</dt>
				<dd class="col-sm-9">${annuncioAttribute.utente}</dd>
			</dl>
<a
				href="${pageContext.request.contextPath}/acquisto/ExecuteAcquistoServlet?idAnnuncio=${annuncioAttribute.id}"
				class="btn btn-primary btn-md">Conferma Acquisto</a>
		</div>
	</div>


</body>
</html>
