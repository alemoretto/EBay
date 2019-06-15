package it.prova.ebay.dao.ruolo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.ebay.model.Ruolo;

@Component
public class RuoloDAOImpl implements RuoloDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> list() {
		return entityManager.createQuery("from Ruolo").getResultList();
	}

	@Override
	public Ruolo get(Long id) {
		return entityManager.find(Ruolo.class, id);
	}

	@Override
	public void update(Ruolo o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Ruolo o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Ruolo o) {
		entityManager.remove(entityManager.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ruolo> findByExample(Ruolo o) {
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
		Criteria criteria = session.createCriteria(Ruolo.class).add(example);
		return criteria.list();
	}

}
