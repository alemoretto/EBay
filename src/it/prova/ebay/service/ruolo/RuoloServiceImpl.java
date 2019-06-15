package it.prova.ebay.service.ruolo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.dao.ruolo.RuoloDAO;
import it.prova.ebay.model.Ruolo;

@Component
public class RuoloServiceImpl implements RuoloService {

	@Autowired
	private RuoloDAO ruoloDAO;

	@Transactional(readOnly = true)
	public List<Ruolo> listAll() {
		return ruoloDAO.list();
	}

	@Transactional(readOnly = true)
	public Ruolo carica(Long id) {
		return ruoloDAO.get(id);
	}

	@Transactional
	public void aggiorna(Ruolo o) {
		ruoloDAO.update(o);
	}

	@Transactional
	public void inserisci(Ruolo o) {
		ruoloDAO.insert(o);
	}

	@Transactional
	public void rimuovi(Ruolo o) {
		ruoloDAO.delete(o);
	}

	@Transactional(readOnly = true)
	public List<Ruolo> findByExample(Ruolo example) {
		return ruoloDAO.findByExample(example);
	}

}
