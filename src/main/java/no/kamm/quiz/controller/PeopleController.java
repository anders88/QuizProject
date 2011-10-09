package no.kamm.quiz.controller;

import no.kamm.quiz.people.PeopleService;
import no.kamm.quiz.people.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PeopleController {

	@Autowired
	private PeopleService peopleService;

	@RequestMapping("/people/list")
	public ModelAndView list() {
		return new ModelAndView("list_people", "people", peopleService.findAll());
	}

	@RequestMapping(value = "/people/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("create_or_update_person", "person", new Person());
	}

	@RequestMapping(value = "/people/create", method = RequestMethod.POST)
	public View create(@ModelAttribute("person") Person person) {
		System.out.println("**************: " + person.getName());
		peopleService.save(person);
		return new RedirectView("/people/list");
	}

}
