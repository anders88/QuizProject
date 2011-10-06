package no.kamm.quiz.integration;

import java.io.Serializable;
import java.util.List;

public interface Repository {

	<T> T retrieve(Class<T> clazz, Serializable key);

	<T> List<T> findAll(Class<T> clazz);

	<T> List<T> find(Specification<T> specification);

	<T> int deleteAll(Class<T> clazz);

	void delete(Serializable entity);

	void save(Serializable entity);

}
