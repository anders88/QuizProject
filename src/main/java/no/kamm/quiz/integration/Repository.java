package no.kamm.quiz.integration;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface Repository {

	Serializable save(Object entity);

	void saveAll(Object... entities);

	<T> void saveAll(Collection<T> entities);

	<T> T retrieve(Class<T> entityClass, Serializable key);

	<T> T retrieve(Specification<T> specification);

	<T> List<T> find(Specification<T> specification);

	<T> List<T> findAll(Class<T> entityClass);

	long rowCount(Specification<?> specification);

	void delete(Class<?> entityClass, Serializable key);

	void deleteAll(Class<?> entityType);

	void delete(Object entity);

	void delete(Specification<?> specification);

}
