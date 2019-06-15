package it.prova.ebay.service.ruolo;

import java.util.List;

import it.prova.ebay.model.Ruolo;

public interface RuoloService {

	public List<Ruolo> listAll();

	public Ruolo carica(Long id);

	public void aggiorna(Ruolo o);

	public void inserisci(Ruolo o);

	public void rimuovi(Ruolo o);

	public List<Ruolo> findByExample(Ruolo example);

}
