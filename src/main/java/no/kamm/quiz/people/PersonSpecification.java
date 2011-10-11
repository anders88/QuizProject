package no.kamm.quiz.people;

import no.kamm.quiz.integration.HibernateSpecification;
import no.kamm.quiz.integration.Specification;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class PersonSpecification implements HibernateSpecification<Person> {

	private Integer id;
	private String name;

	public Specification<Person> withName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public void prepareQuery(DetachedCriteria criteria) {
		if (id != null) {
			criteria.add(Restrictions.eq("id", id));
		}
		if (name != null) {
			criteria.add(Restrictions.like("username", name));
		}
	}

	@Override
	public Class<Person> getEntityClass() {
		return Person.class;
	}

	public Specification<Person> withId(Integer id) {
		this.id = id;
		return this;
	}

}
