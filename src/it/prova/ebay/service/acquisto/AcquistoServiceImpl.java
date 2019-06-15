package it.prova.ebay.service.acquisto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.dao.acquisto.AcquistoDAO;
import it.prova.ebay.dao.annuncio.AnnuncioDAO;
import it.prova.ebay.dao.utente.UtenteDAO;
import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Utente;

@Component
public class AcquistoServiceImpl implements AcquistoService {

	@Autowired
	private AcquistoDAO acquistoDAO;

	@Autowired
	private AnnuncioDAO annuncioDAO;
	
	@Autowired
	private UtenteDAO utenteDAO;
	
	@Transactional(readOnly = true)
	public List<Acquisto> listAll() {
		return acquistoDAO.list();
	}

	@Transactional(readOnly = true)
	public Acquisto carica(Long id) {
		return acquistoDAO.get(id);
	}

	@Transactional
	public void aggiorna(Acquisto o) {
		acquistoDAO.update(o);
	}

	@Transactional
	public void inserisci(Acquisto o) {
		acquistoDAO.insert(o);
	}

	@Transactional
	public void rimuovi(Acquisto o) {
		acquistoDAO.delete(o);
	}

	@Transactional(readOnly = true)
	public List<Acquisto> findByExample(Acquisto example) {
		return acquistoDAO.findByExample(example);
	}
	
	@Transactional
	public boolean acquista(Long idAnnuncio, Long idUtente) {
		
		Utente compratore = utenteDAO.getEager(idUtente);
		Annuncio annuncio = annuncioDAO.getEager(idAnnuncio);
		
		if ( !annuncio.isAperto() || !(annuncio.getPrezzo() <= compratore.getCredito()) ) {
			return false;
		}
		Utente venditore = utenteDAO.getEager(annuncio.getUtente().getId());

		
		double nuovoCreditoCompratore = compratore.getCredito() - annuncio.getPrezzo();
		compratore.setCredito(nuovoCreditoCompratore);
		double nuovoCreditoVenditore = venditore.getCredito() + annuncio.getPrezzo();
		venditore.setCredito(nuovoCreditoVenditore);
		
		Acquisto nuovoAcquisto = new Acquisto(annuncio.getTestoAnnuncio(),annuncio.getPrezzo(),annuncio.getUtente());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		String dataAcquisto = dateFormat.format(new Date());
		nuovoAcquisto.setAnno(Integer.parseInt(dataAcquisto.substring(6, 10)));
		compratore.getAcquisti().add(nuovoAcquisto);
		nuovoAcquisto.setUtente(compratore);
		annuncio.setAperto(false);
		
		annuncioDAO.update(annuncio);
		utenteDAO.update(compratore);
		utenteDAO.update(venditore);

		return true;
		
	}
	
}
