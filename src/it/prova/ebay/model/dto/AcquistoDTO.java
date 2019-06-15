package it.prova.ebay.model.dto;

public class AcquistoDTO {

	private String descrizione;
	private String prezzo;
	private String anno;
	
	public AcquistoDTO(String descrizione, String prezzo, String anno) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.anno = anno;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}
	
}
