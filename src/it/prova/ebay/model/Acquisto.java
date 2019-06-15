package it.prova.ebay.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Acquisto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private Double prezzo;
	private Integer anno;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;

	public Acquisto() {
	}

	public Acquisto(String descrizione, Double prezzo, Integer anno, Utente utente) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.anno = anno;
		this.utente = utente;
	}

	public Acquisto(String descrizione, Double prezzo, Utente utente) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.utente = utente;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
