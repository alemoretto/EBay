package it.prova.ebay.service.utente;

import java.util.List;

import it.prova.ebay.model.Utente;

public interface UtenteService {

	public List<Utente> listAll();

	public Utente carica(Long id);

	public Utente caricaEager(Long id);

	public Utente findByUsername(String username);

	public void aggiorna(Utente o);

	public void inserisci(Utente o);

	public void rimuovi(Utente o);

	public List<Utente> findByExample(Utente example);

	public Utente eseguiAccesso(String username, String password);

	public Utente eseguiAccessoEager(String username, String password);
	
}
