function validateAnnuncio() {

	var isValid = true;

	if (!validateCheckBox("categoria", "Selezionare almeno una categoria")) {
		isValid = false;
	}

	var prefissi = [ "testoAnnuncio", "prezzo" ];
	var messaggio = "Campo obbligatorio";

	if (!validateEmpty(prefissi, messaggio)) {
		return false;
	}

	if (!validatePrezzo("prezzo", "Campo non valido")) {
		return false;
	}

	return isValid;

}

function validateCategoria() {

	var prefissi = [ "descrizione", "codice" ];
	var messaggio = "Campo obbligatorio";

	return validateEmpty(prefissi, messaggio);

}

function validateUtente() {

	var isValid = true;

	if (!validateCheckBox("ruolo", "Selezionare almeno un ruolo")) {
		isValid = false;
	}

	var prefissi = [ "nome", "cognome", "username", "password", "credito" ];
	var messaggio = "Campo obbligatorio";

	if (!validateEmpty(prefissi, messaggio)) {
		return false;
	}

	if (!validatePrezzo("credito", "Campo non valido")) {
		return false;
	}

	return isValid;

}

function validateSignUp() {

	var prefissi = [ "nome", "cognome", "username", "password" ];
	var messaggio = "Campo obbligatorio";

	return validateEmpty(prefissi, messaggio);


}

//###################################################################

function validateEmpty(prefissi, messaggio) {

	var isEmpty = true;

	for (let i = 0; i < prefissi.length; i++) {
		document.getElementById(prefissi[i] + "InputErrorId").style.display = "none";
		if (document.getElementById(prefissi[i] + "InputId").value == "") {
			document.getElementById(prefissi[i] + "InputErrorId").style.display = "block";
			document.getElementById(prefissi[i] + "InputErrorId").innerHTML = messaggio;
			document.getElementById(prefissi[i] + "InputId").style.borderColor = "red";

			isEmpty = false;
		}
	}

	return isEmpty;

}

function validatePrezzo(prefisso, messaggio) {

	document.getElementById(prefisso + "InputErrorId").style.display = "none";
	prezzo = document.getElementById(prefisso + "InputId").value;
	if (isNaN(prezzo) || prezzo < 0) {
		document.getElementById(prefisso + "InputErrorId").style.display = "block";
		document.getElementById(prefisso + "InputErrorId").innerHTML = messaggio;
		document.getElementById(prefisso + "InputId").style.borderColor = "red";

		return false;
	}

	return true;
}

function validateCheckBox(prefisso, messaggio) {

	document.getElementById(prefisso + "InputErrorId").style.display = "none";
	if (document.querySelectorAll('input[type=checkbox]:checked').length <= 0) {
		document.getElementById(prefisso + "InputErrorId").style.display = "block";
		document.getElementById(prefisso + "InputErrorId").innerHTML = messaggio;

		return false;
	}

	return true;
}

function resetStyle(id) {
	document.getElementById(id).style.borderColor = "#ced4da";
}