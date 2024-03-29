<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../js/validate.js"></script>
<title>Inserimento Nuovo Annuncio</title>
</head>
<body>

	<div class="container">


		<%@ include file="../header.jsp"%>


		<div class="page-header">
			<h3>Nuovo Annuncio</h3>
		</div>

		<form class="form-horizontal needs-validation"
			action="${pageContext.request.contextPath}/utente/ExecuteInserisciAnnuncioUtenteServlet"
			method="post" onsubmit="return validateAnnuncio()">

			<div class="form-group">
				<label class="control-label col-sm-2" for="testoAnnuncioInputId">Descrizione:</label>
			 	<c:if test="${messaggiDiErrore.testoAnnuncioInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.testoAnnuncioInput}</div>
				</c:if>  

				<div class="col-sm-8">
					<input class="form-control" type="text" id="testoAnnuncioInputId"
						name="testoAnnuncioInput" value="${annuncioDTOAttribute.testoAnnuncio}" onfocus="resetStyle(id)" >
						<div id="testoAnnuncioInputErrorId" style="display:none;color:red" ></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
				<c:if test="${messaggiDiErrore.prezzoInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.prezzoInput}</div>
				</c:if>

				<div class="col-sm-2">
					<input class="form-control" type="text" id="prezzoInputId"
						name="prezzoInput" value="${annuncioDTOAttribute.prezzo}" onfocus="resetStyle(id)">
						<div id="prezzoInputErrorId" style="display:none;color:red" ></div> 
				</div>
			</div>


			<c:if test="${messaggiDiErrore.categoriaInput != null}">
				<div class="alert alert-danger">
					${messaggiDiErrore.categoriaInput}</div>
			</c:if>
			<c:forEach items="${listaCategorieAttribute}" var="categoriaItem">
				<div class="custom-control custom-checkbox">
					<input id="${categoriaItem.id}" type="checkbox" name="categoriaInput" value="${categoriaItem.id}" class="custom-control-input"
					<c:forEach items="${annuncioDTOAttribute.categorie}" var="categ">
				   		<c:if test="${categ.id == categoriaItem.id}">checked="checked"</c:if>
					</c:forEach>> 
					<label class="custom-control-label" for="${categoriaItem.id}">${categoriaItem.descrizione}</label><br>
				</div>
			</c:forEach>
			<div id="categoriaInputErrorId" style="display:none;color:red" ></div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci
						Annuncio</button>
				</div>
			</div>
		</form>



	</div>
	<!-- /.container -->
</body>
</html>