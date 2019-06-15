package it.prova.ebay.dao.utente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.ebay.model.Utente;

@Component
public class UtenteDAOImpl implements UtenteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> list() {
		return entityManager.createQuery("from Utente").getResultList();
	}

	@Override
	public Utente get(Long id) {
		Utente result = (Utente) entityManager.find(Utente.class, id);
		return result;
	}

	@Override
	public Utente getEager(Long id) {
		Query query = entityManager
				.createQuery("select u FROM Utente u LEFT JOIN FETCH u.ruoli LEFT JOIN FETCH u.acquisti LEFT JOIN FETCH u.annunci where u.id = :id");
		query.setParameter("id", id);
		return (Utente) query.getSingleResult();
	}
	
	public Utente findByUsername(String username) {
		Query query = entityManager
				.createQuery("select u FROM Utente u where u.username = '" + username + "'");
//		query.setParameter("username", username);
//		return (Utente) query.getSingleResult();
		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}
	
	@Override
	public void update(Utente o) {
		entityManager.merge(o);
	}

	@Override
	public void insert(Utente o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Utente o) {
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> findByExample(Utente o) {

		
	String query = "select u from Utente u where 1=1 ";
	
	if (!StringUtils.isEmpty(o.getNome())) {
		query += " and u.nome LIKE '" + o.getNome() + "%' ";
	}
	if (!StringUtils.isEmpty(o.getCognome())) {
		query += " and u.cognome LIKE '" + o.getCognome() + "%' ";
	}
	if (!StringUtils.isEmpty(o.getUsername())) {
		query += " and u.username LIKE '" + o.getUsername() + "%' ";
	}
	if (!StringUtils.isEmpty(o.getPassword())) {
		query += " and u.password LIKE '" + o.getPassword() + "%' ";
	}
	return entityManager.createQuery(query).getResultList();
}

	@Override
	public Utente executeLogin(String username, String password) {
		Query query = entityManager
				.createQuery("select u FROM Utente u where u.username = :usernameParam and u.password= :passwordParam");
		query.setParameter("usernameParam", username);
		query.setParameter("passwordParam", password);

		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}

	@Override
	public Utente executeLoginEager(String username, String password) {
		Query query = entityManager
				.createQuery("select u FROM Utente u LEFT JOIN FETCH u.ruoli where u.username = :usernameParam and u.password= :passwordParam");
		query.setParameter("usernameParam", username);
		query.setParameter("passwordParam", password);

		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}
	
}
