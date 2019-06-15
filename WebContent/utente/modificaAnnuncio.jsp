<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Annuncio</title>
</head>
<body>

	<div class="container">


		<%@ include file="../header.jsp"%>


		<div class="page-header">
			<h3>Modifica Annuncio</h3>
		</div>

		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/utente/ExecuteModificaAnnuncioUtenteServlet"
			method="post">

			<div class="form-group">
				<label class="control-label col-sm-2" for="testoAnnuncioInputId">Descrizione:</label>
				<c:if test="${messaggiDiErrore.testoAnnuncioInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.testoAnnuncioInput}</div>
				</c:if>
				<div class="col-sm-8">
						<input type="hidden" name="idInput" value="${annuncioDTOAttribute.id}">
					<input class="form-control" type="text" id="testoAnnuncioInputId"
						name="testoAnnuncioInput"value="${annuncioDTOAttribute.testoAnnuncio}">
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
						name="prezzoInput" value="${annuncioDTOAttribute.prezzo}"> 
				</div>
			</div>


			<c:if test="${messaggiDiErrore.categoriaInput != null}">
				<div class="alert alert-danger">
					${messaggiDiErrore.categoriaInput}</div>
			</c:if>
			<c:forEach items="${listaCategorieAttribute}" var="categoriaItem" >
				<div class="custom-control custom-checkbox">
					<input id="${categoriaItem.id}" type="checkbox" name="categoriaInput" value="${categoriaItem.id}" class="custom-control-input"
					<c:forEach items="${annuncioDTOAttribute.categorie}" var="categ">
				   		<c:if test="${categ.id == categoriaItem.id}">checked="checked"</c:if>
					</c:forEach>> 
					
<%-- 					<c:if test="${annuncioDTOAttribute.categSelected[loop.index] == 1 }">checked="checked"</c:if> --%>
					<label class="custom-control-label" for="${categoriaItem.id}">${categoriaItem.descrizione}</label><br>
				</div>
			</c:forEach>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Aggiorna</button>
				</div>
			</div>
		</form>



	</div>
	<!-- /.container -->

</body>
</html>