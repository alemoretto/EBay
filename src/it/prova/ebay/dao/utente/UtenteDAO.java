package it.prova.ebay.dao.utente;

import it.prova.ebay.dao.IBaseDAO;
import it.prova.ebay.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public Utente getEager(Long id);

	public Utente executeLogin(String username, String password);

	public Utente executeLoginEager(String username, String password);

	public Utente findByUsername(String username);

}
