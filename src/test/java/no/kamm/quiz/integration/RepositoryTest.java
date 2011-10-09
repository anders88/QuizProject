package no.kamm.quiz.integration;

import static org.fest.assertions.Assertions.assertThat;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import no.kamm.quiz.people.Person;
import no.kamm.quiz.people.PersonSpecification;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/servlet-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class RepositoryTest {

	@Autowired
	private Repository repository;

	@Test
	public void retrieve_with_key() throws Exception {
		String name = "Nils";
		Serializable id = repository.save(new Person().withName(name));
		assertThat(repository.retrieve(Person.class, id).getName()).isEqualTo(name);
	}

	@Test
	public void retrieve_with_specification() throws Exception {
		String name = "Nils";
		repository.save(new Person().withName(name));
		assertThat(repository.retrieve(new PersonSpecification().withName(name)).getName()).isEqualTo(name);
	}

	@Test
	public void find_with_empty_specification() throws Exception {
		Person person1 = new Person().withName("Peter");
		Person person2 = new Person().withName("Paul");

		repository.saveAll(person1, person2);

		assertThat(repository.find(new PersonSpecification())).containsExactly(person1, person2);
	}

	@Test
	public void should_save_a_collection() throws Exception {
		List<Person> people = Arrays.asList(new Person().withName("Peter"), new Person().withName("Paul"));

		repository.saveAll(people);

		assertThat(repository.findAll(Person.class)).hasSize(2);
	}

	@Test
	public void find_with_parameterized_specification() throws Exception {
		Person person1 = new Person().withName("Peter");
		Person person2 = new Person().withName("Paul");

		repository.saveAll(person1, person2);

		assertThat(repository.find(new PersonSpecification().withName("Peter"))).containsExactly(person1);
	}

	@Test
	public void should_find_all() throws Exception {
		Person person1 = new Person().withName("Peter");
		Person person2 = new Person().withName("Paul");

		repository.saveAll(person1, person2);

		assertThat(repository.findAll(Person.class)).containsExactly(person1, person2);
	}

	@Test
	public void should_delete_all() throws Exception {
		Person person1 = new Person().withName("Peter");
		Person person2 = new Person().withName("Paul");

		repository.saveAll(person1, person2);

		repository.deleteAll(Person.class);

		assertThat(repository.findAll(Person.class)).isEmpty();
	}

	@Test
	public void should_delete_a_person() throws Exception {
		Person person1 = new Person().withName("Peter");
		Person person2 = new Person().withName("Paul");

		repository.saveAll(person1, person2);

		repository.delete(person1);

		assertThat(repository.findAll(Person.class)).containsExactly(person2);
	}

	@Test
	public void should_deltete_a_person_with_id() throws Exception {
		Person person1 = new Person().withName("Peter");
		Person person2 = new Person().withName("Paul");

		Serializable id = repository.save(person1);
		repository.save(person2);

		repository.delete(Person.class, id);

		assertThat(repository.findAll(Person.class)).containsExactly(person2);
	}

	@Test
	public void should_find_saved_people() throws Exception {
		Person person1 = new Person().withName("Peter");
		Person person2 = new Person().withName("Paul");
		Person person3 = new Person().withName("Espen");

		repository.saveAll(person1, person2, person3);

		assertThat(repository.rowCount(new PersonSpecification())).isEqualTo(3);
		assertThat(repository.rowCount(new PersonSpecification().withName("Paul"))).isEqualTo(1);
	}

	@Test
	public void should_delete_all_that_matches_specification() throws Exception {
		Person person1 = new Person().withName("Peter");
		Person person2 = new Person().withName("Paul");
		Person person3 = new Person().withName("Espen");

		repository.saveAll(person1, person2, person3);

		repository.delete(new PersonSpecification().withName("Paul"));

		assertThat(repository.findAll(Person.class)).containsExactly(person1, person3);
	}

}
