<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../../js/validate.js"></script>
<title>Inserimento Nuova Categoria</title>
</head>
<body>

	<div class="container">


		<%@ include file="../../header.jsp"%>


		<div class="page-header">
			<h3>Nuova Categoria</h3>
		</div>

		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/admin/categoria/ExecuteInserisciCategoriaServlet"
			method="post" onsubmit="return validateCategoria()">

			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<c:if test="${messaggiDiErrore.descrizioneInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.descrizioneInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput"
						value="${categoriaDTOAttribute.descrizione}"
						onfocus="resetStyle(id)">
					<div id="descrizioneInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
				<c:if test="${messaggiDiErrore.codiceInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.codiceInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId"
						name="codiceInput" value="${categoriaDTOAttribute.codice}"
						onfocus="resetStyle(id)">
					<div id="codiceInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci
						nuova Categoria</button>
				</div>
			</div>
		</form>



	</div>
	<!-- /.container -->

</body>
</html>