<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elimina Categoria</title>
</head>
<body>

	<div class="container">
		<%@ include file="../../header.jsp"%>

		<div class="page-header">
			<h3>Elimina Categoria:</h3>
		</div>
		<br>
		<div class="container-fluid" id="idContainer">

		<c:if test="${messaggioDiErrore != null}">
			<div class="alert alert-danger">
				${messaggioDiErrore}</div>
		</c:if>
		
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${categoriaDTOAttribute.descrizione}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice</dt>
				<dd class="col-sm-9">${categoriaDTOAttribute.codice}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Annunci associati</dt>
				<dd class="col-sm-9">${categoriaDTOAttribute.numeroAnnunciAssociati}</dd>
			</dl>
			<a
				href="${pageContext.request.contextPath}/admin/categoria/ExecuteEliminaCategoriaServlet?idCategoria=${categoriaDTOAttribute.id}"
				class="btn btn-primary btn-md">Elimina</a>
		</div>
	</div>


</body>
</html>
