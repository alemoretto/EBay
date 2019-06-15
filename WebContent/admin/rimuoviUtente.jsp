<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Utente</title>
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

			<%@ include file="details.jsp"%>

			<a
				href="${pageContext.request.contextPath}/admin/ExecuteEliminaUtenteServlet?idUtente=${utenteDTOAttribute.id}"
				class="btn btn-primary btn-md">Rimuovi</a>
		</div>
	</div>


</body>
</html>
