
<c:forEach items="${utenteDTOAttribute.fieldsNames()}" var="field"
	varStatus="loop">
	<div class="form-group">
		<label class="control-label col-sm-2" for="${field.value}Id">${field.key}:</label>
		<c:if test="${messaggiDiErrore[field.value] != null}">
			<div class="alert alert-danger">
				${messaggiDiErrore[field.value]}</div>
		</c:if>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="${field.value}Id"
				name="${field.value}"
				value="${utenteDTOAttribute.fieldsValues[field.key]}">
		</div>
	</div>
</c:forEach>
