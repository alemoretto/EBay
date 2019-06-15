package it.prova.ebay.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.dao.categoria.CategoriaDAO;
import it.prova.ebay.model.Categoria;

@Component
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Transactional(readOnly = true)
	public List<Categoria> listAll() {
		return categoriaDAO.list();
	}

	@Transactional(readOnly = true)
	public Categoria carica(Long id) {
		return categoriaDAO.get(id);
	}

	@Transactional(readOnly = true)
	public Categoria caricaEager(Long id) {
		return categoriaDAO.getEager(id);
	}

	@Transactional
	public void aggiorna(Categoria o) {
		categoriaDAO.update(o);
	}

	@Transactional
	public void inserisci(Categoria o) {
		categoriaDAO.insert(o);
	}

	@Transactional
	public void rimuovi(Categoria o) {
		categoriaDAO.delete(o);
	}

	@Transactional(readOnly = true)
	public List<Categoria> findByExample(Categoria example) {
		return categoriaDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public List<Categoria> findByExampleEager(Categoria example) {
		return categoriaDAO.findByExampleEager(example);
	}

	@Transactional(readOnly = true)
	public boolean existDescrizione(String descrizione) {
		return categoriaDAO.existDescrizione(descrizione);
	}

	@Transactional(readOnly = true)
	public boolean existCodice(String codice) {
		return categoriaDAO.existDescrizione(codice);
	}

}
