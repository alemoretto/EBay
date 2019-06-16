function validateAnnuncio() {
	
	var isValid = true;
	
	if (!validateCheckBox("categoria", "Selezionare almeno una categoria")){
		isValid = false;
	}
	
	var prefissi = [ "testoAnnuncio", "prezzo" ];
	var messaggio = "Campo obbligatorio";

	if (!validateEmpty(prefissi,messaggio)){
		return false;
	}
	
	if (!validatePrezzo("prezzo", "Campo non valido")){
		return false;
	}
	
	return isValid;
	
}