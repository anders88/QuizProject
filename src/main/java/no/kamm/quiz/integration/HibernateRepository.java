package no.kamm.quiz.integration;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "repository")
public class HibernateRepository implements Repository {

	private final SessionFactory sessionFactory;

	@Autowired
	public HibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Serializable save(Object entity) {
		Session session = getSession();
		session.saveOrUpdate(entity);
		return session.getIdentifier(entity);
	}

	@Override
	public void saveAll(Object... entities) {
		for (Object entity : entities) {
			getSession().saveOrUpdate(entity);
		}
	}

	@Override
	public <T> void saveAll(Collection<T> entities) {
		for (T entity : entities) {
			getSession().saveOrUpdate(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T retrieve(Class<T> entityClass, Serializable key) {
		return (T) getSession().get(entityClass, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T retrieve(Specification<T> specification) {
		return (T) createCriteria(specification).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(Specification<T> specification) {
		return createCriteria(specification).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(Class<T> entityClass) {
		return getSession().createCriteria(entityClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}

	@Override
	public long rowCount(Specification<?> specification) {
		Criteria criteria = createCriteria(specification);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.list().get(0);
	}

	@Override
	public void delete(Class<?> entityClass, Serializable key) {
		if (key instanceof Number || key instanceof String) {
			getSession().createQuery("delete " + entityClass.getName() + " where id = ?")
					.setParameter(0, key).executeUpdate();
		} else if (key != null) {
			Object entity = retrieve(entityClass, key);
			if (entity != null)
				getSession().delete(entity);
		}
	}

	@Override
	public void delete(Object entity) {
		getSession().delete(entity);
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void deleteAll(Class<?> entityType) {
		getSession().createQuery("delete " + entityType.getName()).executeUpdate();
	}

	@Override
	public void delete(Specification<?> specification) {
		List<?> entities = find(specification);
		for (Object entity : entities) {
			delete(entity);
		}
	}

	private <T> Criteria createCriteria(Specification<T> specification) {
		if (specification == null) {
			throw new NullPointerException("Parameter specification er null");
		}
		if (!(specification instanceof HibernateSpecification)) {
			throw new IllegalArgumentException(specification.getClass().getName() + " må være av typen "
					+ HibernateSpecification.class.getName());
		}
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(specification.getEntityClass());
		((HibernateSpecification<T>) specification).prepareQuery(detachedCriteria);
		return detachedCriteria.getExecutableCriteria(getSession());
	}

}
