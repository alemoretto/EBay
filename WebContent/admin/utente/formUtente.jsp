
<div class="form-group">
	<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	<c:if test="${messaggiDiErrore.nomeInput != null}">
		<div class="alert alert-danger">${messaggiDiErrore.nomeInput}</div>
	</c:if>
	<div class="col-sm-4">
		<input class="form-control" type="text" id="nomeInputId"
			name="nomeInput" value="${utenteDTOAttribute.nome}"
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
			name="cognomeInput" value="${utenteDTOAttribute.cognome}"
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
			name="usernameInput" value="${utenteDTOAttribute.username}"
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
			name="passwordInput" value="${utenteDTOAttribute.password}"
			onfocus="resetStyle(id)">
		<div id="passwordInputErrorId" style="display: none; color: red"></div>
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
			name="creditoInput" value="${utenteDTOAttribute.credito}"
			onfocus="resetStyle(id)">
		<div id="creditoInputErrorId" style="display: none; color: red"></div>
	</div>
</div>

<c:if test="${messaggiDiErrore.ruoloInput != null}">
	<div class="alert alert-danger">${messaggiDiErrore.ruoloInput}</div>
</c:if>
<c:forEach items="${listRuoliAttribute}" var="ruoloItemLista">
	<input type="checkbox" name="ruoloInput" value="${ruoloItemLista.id}"
		<c:forEach items="${utenteDTOAttribute.ruoli}" var="ruolo">
				   		<c:if test="${ruolo.id == ruoloItemLista.id}">checked="checked"</c:if>
					</c:forEach>> 
					${ruoloItemLista.descrizione}<br>
</c:forEach>
<div id="ruoloInputErrorId" style="display: none; color: red"></div>
