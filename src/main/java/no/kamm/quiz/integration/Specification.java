package no.kamm.quiz.integration;

import org.hibernate.criterion.DetachedCriteria;

public interface Specification<T> {

	DetachedCriteria getCriteria();

}
