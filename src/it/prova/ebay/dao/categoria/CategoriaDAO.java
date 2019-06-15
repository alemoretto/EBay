package it.prova.ebay.dao.categoria;

import java.util.List;

import it.prova.ebay.dao.IBaseDAO;
import it.prova.ebay.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {

	List<Categoria> findByExampleEager(Categoria o);

	public boolean existDescrizione(String descrizione);

	public boolean existCodice(String codice);
	
	public Categoria getEager(Long id);
	
}
