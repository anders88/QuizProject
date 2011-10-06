package no.kamm.quiz.integration;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateRepository extends HibernateDaoSupport implements Repository {

	@Override
	public <T> T retrieve(Class<T> clazz, Serializable key) {
		return getHibernateTemplate().get(clazz, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(Specification<T> specification) {
		return getHibernateTemplate().findByCriteria(specification.getCriteria());
	}

	@Override
	public <T> int deleteAll(Class<T> clazz) {
		return getHibernateTemplate().getSessionFactory().openSession().createQuery("DELETE FROM " + clazz)
				.executeUpdate();
	}

	@Override
	public void delete(Serializable entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void save(Serializable entity) {
		getHibernateTemplate().save(entity);
	}

}
