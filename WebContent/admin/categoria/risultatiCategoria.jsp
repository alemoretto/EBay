<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati di ricerca</title>
</head>
<body>
<div class="container">

	<%@ include file="../../header.jsp" %>

  	<div class="page-header">
	  <h3>La ricerca ha prodotto ${listaCategorieAttribute.size()} risultati: </h3>
	</div>
  	
<table class="table table-striped">
		<thead>
			<tr>
				<th>Categoria</th>
				<th>Codice</th>
			</tr>
		</thead>
		
		<c:forEach items="${listaCategorieAttribute}" var="categoriaItem">
			<tr>
				<td>${categoriaItem.descrizione}</td>
				<td>${categoriaItem.codice}</td>
				<td>
					<a href="${pageContext.request.contextPath}/admin/categoria/PrepareModificaCategoriaServlet?idCategoria=${categoriaItem.id}" class="btn btn-info">Modifica</a>
					<a href="${pageContext.request.contextPath}/admin/categoria/PrepareEliminaCategoriaServlet?idCategoria=${categoriaItem.id}" class="btn btn-info">Elimina</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</div>
</body>
</html>



