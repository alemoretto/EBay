package it.prova.ebay.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.prova.ebay.model.Ruolo;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private double credito;
	@Temporal(TemporalType.DATE)
	private Date dataRegistrazione;
	@ManyToMany
	@JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ruolo_id", referencedColumnName = "id"))
	private Set<Ruolo> ruoli = new HashSet<>(0);
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utente", orphanRemoval = true)
	private Set<Acquisto> acquisti = new HashSet<>(0);
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utente", orphanRemoval = true)
	private Set<Annuncio> annunci = new HashSet<>(0);
	
	public Utente() {
	}

	public Utente(Long id, String nome, String cognome, String username, String password, Date dataRegistrazione,
			Set<Ruolo> ruoli, Set<Acquisto> acquisti, Set<Annuncio> annunci) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
		this.ruoli = ruoli;
		this.acquisti = acquisti;
		this.annunci = annunci;
	}

	public Utente(String nome, String cognome, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}
	 
	public boolean isAdmin() {
		for (Ruolo ruoloItem : ruoli) {
			if(ruoloItem.getCodice().equals(Ruolo.ADMIN_ROLE))
				return true;
		}
		return false;
	}
	
	public boolean isClassic() {
		for (Ruolo ruoloItem : ruoli) {
			if(ruoloItem.getCodice().equals(Ruolo.CLASSIC_USER_ROLE))
				return true;
		}
		return false;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public Set<Acquisto> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(Set<Acquisto> acquisti) {
		this.acquisti = acquisti;
	}

	public Set<Annuncio> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<Annuncio> annunci) {
		this.annunci = annunci;
	}
	
	
}
