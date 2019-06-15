<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Categoria</title>
</head>
<body>

<div class="container">

   <%@ include file="../../header.jsp" %>
      
    <div class="page-header">
	  <h3>Ricerca Categoria</h3>
	</div>

<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/categoria/ExecuteRicercaCategoriaServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="testoAnnuncioInputId">Titolo:</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="testoAnnuncioInputId"
						name="testoAnnuncioInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="prezzoInputId">Prezzo:</label>
				<div class="col-sm-2">
					<input class="form-control" type="text" id="prezzoInputId"
						name="prezzoInput">
				</div>
			</div>
			<br>
			
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Cerca
						Categorie</button>
			<a href="${pageContext.request.contextPath}/admin/categoria/PrepareInserisciCategoriaServlet" class="btn btn-primary btn-md">Inserisci</a>
				</div>
			</div>
		</form>
	
    </div><!-- /.container -->



</body>
</html>