package it.prova.ebay.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Annuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String testoAnnuncio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;
	private double prezzo;
	@Temporal(TemporalType.DATE)
	private Date dataPubblicazione;
	private boolean aperto;
	@ManyToMany
	@JoinTable(name = "annuncio_categoria", joinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "id"))
	private Set<Categoria> categorie = new HashSet<>(0);

	public Annuncio() {
	}

	public Annuncio(String testoAnnuncio, Utente utente, double prezzo, boolean aperto) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.utente = utente;
		this.prezzo = prezzo;
		this.aperto = aperto;
	}

	public Annuncio(String testoAnnuncio, double prezzo, boolean aperto) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.aperto = aperto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}

	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	
	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

	public boolean isAperto() {
		return aperto;
	}

	public void setAperto(boolean aperto) {
		this.aperto = aperto;
	}
	
}
