<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/validate.js"></script>
<title>Sign Up</title>
</head>
<body>

	<div class="container">


		<%@ include file="../header.jsp"%>


		<div class="page-header">
			<h3>Registrati</h3>
		</div>

		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/SignUpServlet"
			method="post"  onsubmit="return validateSignUp()">


			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<c:if test="${messaggiDiErrore.nomeInput != null}">
					<div class="alert alert-danger">${messaggiDiErrore.nomeInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="${utenteDTOAttribute.nome}" placeholder="Nome"
						onfocus="resetStyle(id)">
					<div id="nomeInputErrorId" style="display: none; color: red"></div>

				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<c:if test="${messaggiDiErrore.cognomeInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.cognomeInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="${utenteDTOAttribute.cognome}" placeholder="Cognome"
						onfocus="resetStyle(id)">
					<div id="cognomeInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="usernameInputId">Username:</label>
				<c:if test="${messaggiDiErrore.usernameInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.usernameInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameInputId"
						name="usernameInput" value="${utenteDTOAttribute.username}" placeholder="Username"
						onfocus="resetStyle(id)">
					<div id="usernameInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="passwordInputId">Password:</label>
				<c:if test="${messaggiDiErrore.passwordInput != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore.passwordInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="password" id="passwordInputId"
						name="passwordInput"  placeholder="Password"
						onfocus="resetStyle(id)">
					<div id="passwordInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="ripetiPasswordInputId">Ripeti Password:</label>
				<div class="col-sm-4">
					<input class="form-control" type="password" id="ripetiPasswordInputId"
						name="ripetiPasswordInput" placeholder="Ripeti Password"
						onfocus="resetStyle(id)">
					<div id="ripetiPasswordInputErrorId" style="display: none; color: red"></div>
				</div>
			</div>

			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Registrati</button>
				</div>
			</div>
		</form>



	</div>
	<!-- /.container -->

</body>
</html>