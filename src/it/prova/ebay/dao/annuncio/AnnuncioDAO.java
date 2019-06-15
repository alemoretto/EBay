package it.prova.ebay.dao.annuncio;

import java.util.List;

import it.prova.ebay.dao.IBaseDAO;
import it.prova.ebay.model.Annuncio;

public interface AnnuncioDAO extends IBaseDAO<Annuncio> {

	public List<Annuncio> findByExampleEager(Annuncio example);
	
	public Annuncio getEager(Long id);
	
}
