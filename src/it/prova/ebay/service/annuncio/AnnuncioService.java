package it.prova.ebay.service.annuncio;

import java.util.List;

import it.prova.ebay.model.Annuncio;

public interface AnnuncioService {

	public List<Annuncio> listAll();

	public Annuncio carica(Long id);

	public Annuncio caricaEager(Long id);
	
	public void aggiorna(Annuncio o);

	public void inserisci(Annuncio o);

	public void rimuovi(Annuncio o);

	public List<Annuncio> findByExample(Annuncio example);
	
	public List<Annuncio> findByExampleEager(Annuncio example);

}
