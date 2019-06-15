package it.prova.ebay.service.categoria;

import java.util.List;

import it.prova.ebay.model.Categoria;

public interface CategoriaService {

	public List<Categoria> listAll();

	public Categoria carica(Long id);

	public void aggiorna(Categoria o);

	public void inserisci(Categoria o);

	public void rimuovi(Categoria o);

	public List<Categoria> findByExample(Categoria example);

}