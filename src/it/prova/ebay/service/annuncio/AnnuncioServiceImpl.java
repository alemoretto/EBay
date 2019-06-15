package it.prova.ebay.service.annuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.dao.annuncio.AnnuncioDAO;
import it.prova.ebay.model.Annuncio;

@Component
public class AnnuncioServiceImpl implements AnnuncioService {

	@Autowired
	private AnnuncioDAO annuncioDAO;

	@Transactional(readOnly = true)
	public List<Annuncio> listAll() {
		return annuncioDAO.list();
	}

	@Transactional(readOnly = true)
	public Annuncio carica(Long id) {
		return annuncioDAO.get(id);
	}

	@Transactional(readOnly = true)
	public Annuncio caricaEager(Long id) {
		return annuncioDAO.getEager(id);
	}
	
	@Transactional
	public void aggiorna(Annuncio o) {
		annuncioDAO.update(o);
	}

	@Transactional
	public void inserisci(Annuncio o) {
		annuncioDAO.insert(o);
	}

	@Transactional
	public void rimuovi(Annuncio o) {
		annuncioDAO.delete(o);
	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByExample(Annuncio example) {
		return annuncioDAO.findByExample(example);
	}
	
	public List<Annuncio> findByExampleEager(Annuncio example){
		return annuncioDAO.findByExampleEager(example);
	}

}
