package it.prova.ebay.model;

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

import it.prova.ebay.model.Categoria;

@Entity
public class Acquisto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private double prezzo;
	private int anno;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;
	@ManyToMany
	@JoinTable(name = "acquisto_categoria", joinColumns = @JoinColumn(name = "acquisto_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "id"))
	private Set<Categoria> categorie = new HashSet<>(0);

	public Acquisto() {
	}

	public Acquisto(String descrizione, double prezzo, int anno, Utente utente, Set<Categoria> categorie) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.anno = anno;
		this.utente = utente;
		this.categorie = categorie;
	}

	public Acquisto(String descrizione, double prezzo, int anno, Utente utente) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.anno = anno;
		this.utente = utente;
	}
	
	public Acquisto(String descrizione, double prezzo, Utente utente) {
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

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

}
