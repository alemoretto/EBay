package it.prova.ebay.service.acquisto;

import java.util.List;

import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Utente;

public interface AcquistoService {

	public List<Acquisto> listAll();

	public Acquisto carica(Long id);

	public void aggiorna(Acquisto o);

	public void inserisci(Acquisto o);

	public void rimuovi(Acquisto o);

	public List<Acquisto> findByExample(Acquisto example);

	public boolean acquista(Utente compratore, Annuncio annuncio);
}