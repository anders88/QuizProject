package no.kamm.quiz.integration;

import org.hibernate.criterion.DetachedCriteria;

public interface HibernateSpecification<T> extends Specification<T> {

    void prepareQuery(DetachedCriteria criteria);

}
