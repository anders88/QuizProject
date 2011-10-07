package no.kamm.quiz.integration;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class HibernateRepository implements Repository {

	HibernateTemplate hibernateTemplate;

	@Autowired
	public HibernateRepository(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public <T> T retrieve(Class<T> clazz, Serializable key) {
		return hibernateTemplate.get(clazz, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		return hibernateTemplate.findByCriteria(DetachedCriteria.forClass(clazz));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> find(Specification<T> specification) {
		return hibernateTemplate.findByCriteria(specification.getCriteria());
	}

	@Override
	public <T> int deleteAll(Class<T> clazz) {
		return hibernateTemplate.getSessionFactory().openSession()
				.createQuery("DELETE FROM " + clazz.getName()).executeUpdate();
	}

	@Override
	public void delete(Serializable entity) {
		hibernateTemplate.delete(entity);
	}

	@Override
	public void save(Serializable entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

}
