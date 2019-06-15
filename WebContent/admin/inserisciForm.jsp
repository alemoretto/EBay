
		<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/ExecuteInserisciUtenteServlet" method="post">

			<div class="form-group">
		<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
		<c:if test="${messaggiDiErrore.nomeInput != null}">
			<div class="alert alert-danger">
				${messaggiDiErrore.nomeInput}</div>
		</c:if>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="nomeInputId"
				name="nomeInput"
				value="${utenteDTOAttribute.nome}">
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
				name="cognomeInput"
				value="${utenteDTOAttribute.cognome}">
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
				name="usernameInput"
				value="${utenteDTOAttribute.username}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-2" for="passwordInputId">Password:</label>
		<c:if test="${messaggiDiErrore.passwordInput != null}">
			<div class="alert alert-danger">
				${messaggiDiErrore.passwordInput}</div>
		</c:if>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="passwordInputId"
				name="passwordInput"
				value="${utenteDTOAttribute.password}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-2" for="creditoInputId">Credito:</label>
		<c:if test="${messaggiDiErrore.creditoInput != null}">
			<div class="alert alert-danger">
				${messaggiDiErrore.creditoInput}</div>
		</c:if>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="creditoInputId"
				name="creditoInput"
				value="${utenteDTOAttribute.credito}">
		</div>
	</div>
		<c:if test="${messaggiDiErrore.ruoloInput != null}">
			<div class="alert alert-danger">
				${messaggiDiErrore.ruoloInput}</div>
		</c:if>
			<c:forEach items="${listRuoliAttribute}" var="ruoloItemLista">
				<input type="checkbox" name="ruoloInput" value="${ruoloItemLista.id}"> ${ruoloItemLista.descrizione}<br>
			</c:forEach>
<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci nuovo Utente</button>
				</div>
			</div>
		</form>