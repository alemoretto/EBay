<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<dl class="row">
	<dt class="col-sm-3 text-right">Nome</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.nome}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Cognome</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.cognome}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Username</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.username}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Password</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.password}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Credito</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.credito}</dd>
</dl>

<dl class="row">
	<dt class="col-sm-3 text-right">Ruolo</dt>
	<dd class="col-sm-9">
		<c:forEach items="${utenteDTOAttribute.ruoli}" var="ruolo"
			varStatus="loop">
				${ruolo.descrizione} 
				<c:if test="${utenteDTOAttribute.ruoli.size()-1 > loop.index}">, </c:if>
		</c:forEach>
	</dd>
</dl>
<dl class="row">
	<dt class="col-sm-3 text-right">Registrato il</dt>
	<dd class="col-sm-9">${utenteDTOAttribute.dataRegistrazione}</dd>
</dl>