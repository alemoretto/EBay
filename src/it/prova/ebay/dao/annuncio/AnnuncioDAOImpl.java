package it.prova.ebay.dao.annuncio;

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

import it.prova.ebay.model.Annuncio;

@Component
public class AnnuncioDAOImpl implements AnnuncioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> list() {
		return entityManager.createQuery("from Annuncio").getResultList();
	}

	@Override
	public Annuncio get(Long id) {
		return entityManager.find(Annuncio.class, id);
	}

	@Override
	public Annuncio getEager(Long id) {
		Query q = entityManager.createQuery("SELECT a from Annuncio a JOIN FETCH a.utente LEFT JOIN FETCH a.categorie WHERE a.id= :id");
		q.setParameter("id", id);
		return (Annuncio) q.getSingleResult();
	}

	@Override
	public void update(Annuncio o) {
		entityManager.merge(o);
	}

	@Override
	public void insert(Annuncio o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Annuncio o) {
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByExample(Annuncio o) {
		Session session = (Session) entityManager.getDelegate();

		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if (object == null)
					return false;
				// String
				if (object instanceof String)
					return StringUtils.isNotBlank((String) object);
				// Number
				if (object instanceof Integer)
					return ((Integer) object) != 0;
				return true;
			}
		};

		Example example = Example.create(o).setPropertySelector(ps).enableLike(MatchMode.START);
		Criteria criteria = session.createCriteria(Annuncio.class).add(example);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByExampleEager(Annuncio o) {

		/*
		 * String query =
		 * "SELECT DISTINCT a FROM Annuncio a LEFT JOIN FETCH  a.categorie c WHERE a.aperto=TRUE AND a.testoAnnuncio LIKE '%"
		 * + o.getTestoAnnuncio() + "%' "; if (o.getPrezzo() != -1) { query +=
		 * " AND a.prezzo < " + Double.toString(o.getPrezzo()); } if
		 * (o.getCategorie().size() > 0) { for (Categoria categoria : o.getCategorie())
		 * { query += " AND c.id= " + Long.toString(categoria.getId()); } } Query q =
		 * entityManager.createQuery(query);
		 */

		String query = "SELECT DISTINCT a FROM Annuncio a LEFT JOIN FETCH  a.categorie c WHERE a.aperto=TRUE AND a.testoAnnuncio LIKE :testo AND c IN (:lista)";

		if (o.getPrezzo() != -1) {
			query += " AND a.prezzo < " + Double.toString(o.getPrezzo());
		}

		Query q = entityManager.createQuery(query);
		q.setParameter("testo", o.getTestoAnnuncio() + "%");
		q.setParameter("lista", o.getCategorie());

		return (List<Annuncio>) q.getResultList();

	}

}
