package no.kamm.quiz.people;

import javax.annotation.Resource;

import no.kamm.quiz.integration.Repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PeopleService {

	@Resource(name = "repository")
	private Repository repository;

	public Person getPerson() {
		repository.save(new Person().withName("Knut"));
		Integer id = (Integer) repository.save(new Person().withName("Per"));
		repository.save(new Person().withName("Pål"));
		repository.save(new Person().withName("Espen"));

		return repository.retrieve(new PersonSpecification().withId(id));
	}

	public long getPeopleCount() {
		return repository.rowCount(new PersonSpecification());
	}

}
