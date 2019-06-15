package it.prova.ebay.dao.categoria;

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
import it.prova.ebay.model.Categoria;

@Component
public class CategoriaDAOImpl implements CategoriaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> list() {
		return entityManager.createQuery("from Categoria").getResultList();
	}

	@Override
	public Categoria get(Long id) {
		return entityManager.find(Categoria.class, id);
	}

	public Categoria getEager(Long id) {
		return (Categoria) entityManager.createQuery("SELECT c FROM Categoria c LEFT JOIN FETCH c.annunci WHERE c.id = " + Long.toString(id)).getSingleResult();
	}
	
	@Override
	public void update(Categoria o) {
		entityManager.merge(o);
	}

	@Override
	public void insert(Categoria o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Categoria o) {
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findByExample(Categoria o) {
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
		Criteria criteria = session.createCriteria(Categoria.class).add(example);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findByExampleEager(Categoria o) {

		/*
		 * String query =
		 * "SELECT DISTINCT a FROM Annuncio a LEFT JOIN FETCH  a.categorie c WHERE a.aperto=TRUE AND a.testoAnnuncio LIKE '%"
		 * + o.getTestoAnnuncio() + "%' "; if (o.getPrezzo() != -1) { query +=
		 * " AND a.prezzo < " + Double.toString(o.getPrezzo()); } if
		 * (o.getCategorie().size() > 0) { for (Categoria categoria : o.getCategorie())
		 * { query += " AND c.id= " + Long.toString(categoria.getId()); } } Query q =
		 * entityManager.createQuery(query);
		 */

		String query = "SELECT c FROM Categoria c LEFT JOIN FETCH c.annunci a WHERE 1=1";

		for (Annuncio annuncio : o.getAnnunci()) {
			if (!StringUtils.isEmpty(annuncio.getTestoAnnuncio())) {
				query += " AND a.testoAnnuncio LIKE '%" + annuncio.getTestoAnnuncio() + "%' ";
			}

			if (annuncio.getPrezzo() != -1) {
				query += " AND a.prezzo < " + Double.toString(annuncio.getPrezzo());
			}
		}

		Query q = entityManager.createQuery(query + " GROUP BY c");

		return (List<Categoria>) q.getResultList();

	}

	@Override
	public boolean existDescrizione(String descrizione) {

		return !entityManager.createQuery("SELECT c FROM Categoria c WHERE c.descrizione = '" + descrizione + "'").getResultList().isEmpty();
				
	}

	@Override
	public boolean existCodice(String codice) {

		return !entityManager.createQuery("SELECT c FROM Categoria c WHERE c.descrizione = '" + codice + "'").getResultList().isEmpty();
		
	}
	
}
