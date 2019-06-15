<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Bootstrap -->
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

<!-- Static navbar -->
<nav class="navbar navbar-expand-lg navbar-light " style="background-color: #e3f2fd;">
	<a class="navbar-brand" href="<%= request.getContextPath()%>/home">E-Bay</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
<%-- 			<li class="nav-item active"><a class="nav-link" href="<%= request.getContextPath()%>/">Home --%>
<!-- 					<span class="sr-only">(current)</span> -->
<!-- 			</a></li> -->
			<li class="nav-item active">
			<c:if test="${sessionScope.userInfo != null && sessionScope.userInfo.isClassic()}">
						<a class="nav-link" href="<%= request.getContextPath()%>/utente/PrepareAreaPrivataServlet">Area Privata</a>
					</c:if>
			</li>
			<li class="nav-item active">
			<c:if test="${sessionScope.userInfo != null && sessionScope.userInfo.isAdmin()}">
						<a class="nav-link" href="<%= request.getContextPath()%>/admin/PrepareRicercaUtenteServlet">Gestione Utenti</a>
					</c:if>
			</li>
			
		</ul>
		 <ul class="nav navbar-nav navbar-right">
			<c:if test="${sessionScope.userInfo == null}">
            	<a href="<%= request.getContextPath()%>/login.jsp">Login</a>
            </c:if> 
            <c:if test="${sessionScope.userInfo != null}">
            	<li><p class="navbar-text">Loggato come:  <strong>${userInfo.username }</strong> (${userInfo.nome } ${userInfo.cognome } - Credito = ${userInfo.credito })
            	<a href="<%= request.getContextPath()%>/LogoutServlet">Logout</a></p>
            </c:if>
            
          </ul>
	</div>
</nav>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%= request.getContextPath() %>/js/jquery-1.10.2.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.bundle.js"></script>
<script	src="<%=request.getContextPath()%>/js/jqueryUI/jquery-ui.min.js"></script>