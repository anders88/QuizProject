package no.kamm.quiz.security;

import no.kamm.quiz.people.Person;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		/**
		 * TODO: Fetch user from database with the given username
		 * Spring-security checks if the password is correct, and throws bad credentials if not
		 * Hash password in the database with SHA-256
		 * Returns person with username admin and password admin at the moment ..
		 */
		return new Person().withName("admin");
	}

}
