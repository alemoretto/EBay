<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Articoli</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<br>
		<c:if test="${messaggio != null}">
			<div class="alert alert-danger">${messaggio}</div>
		</c:if>
		<div class="page-header">
			<h2>Ricerca</h2>
		</div>
		
		<form class="form-horizontal" action="ExecuteRicercaAnnuncioServlet" name="formRicerca"
			method="post" onsubmit="return validateForm()">
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
			
			<c:forEach items="${listaCategorieAttribute}" var="categoriaItem">
				<div class="custom-control custom-checkbox">
					<input id="${categoriaItem.id}" type="checkbox" name="categoriaInput" value="${categoriaItem.id}" class="custom-control-input"> 
					<label class="custom-control-label" for="${categoriaItem.id}">${categoriaItem.descrizione}</label><br>
				</div>
			</c:forEach>
			
			
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Cerca
						annunci</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->


<script>
function validateForm() {
// 	var allInput = document.forms["form_name"].getElementsByTagName("input");
//   var x = document.forms["formRicerca"]["testoAnnuncioInputId"].value;
var elements = document.getElementById("formRicerca").elements;
for (var i = 0, element; element = elements[i++];) {
    if (element.type === "text" && element.value === "")
        element.innerHTML = "CAZZO";
    alert("it's an empty textfield")
}
//   if (x == "") {
//     alert("Name must be filled out");
//     return false;
  return  false;
  
}
</script>
</body>
</html>