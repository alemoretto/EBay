<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../../js/validate.js"></script>
<title>Inserimento Nuovo Utente</title>
</head>
<body>

	<div class="container">


		<%@ include file="../../header.jsp"%>


		<div class="page-header">
			<h3>Nuovo Utente</h3>
		</div>

		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/admin/utente/ExecuteInserisciUtenteServlet"
			method="post" onsubmit="return validateUtente()">

			<%@ include file="formUtente.jsp"%>

			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci
						nuovo Utente</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->

</body>
</html>