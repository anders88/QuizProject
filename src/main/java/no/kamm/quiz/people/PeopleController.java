package no.kamm.quiz.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		return new ModelAndView("create_person", "person", new Person());
	}

	@RequestMapping(value = "/people/create", method = RequestMethod.POST)
	public View create(@ModelAttribute("person") Person person) {
		peopleService.save(person);
		return new RedirectView("/people/list");
	}

	@RequestMapping("/people/show")
	public ModelAndView show(@RequestParam(value = "id", required = true) Integer id) {
		return new ModelAndView("show_person", "person", peopleService.find(id));
	}

	@RequestMapping("/people/update")
	public ModelAndView update(@RequestParam(value = "id", required = true) Integer id) {
		return new ModelAndView("update_person", "person", peopleService.find(id));
	}

	@RequestMapping(value = "/people/update", method = RequestMethod.POST)
	public View update(@ModelAttribute("person") Person person,
			@RequestParam(value = "id", required = true) Integer id) {
		person.setId(id);
		peopleService.save(person);
		return new RedirectView("/people/list");
	}

	@RequestMapping("/people/delete")
	public View delete(@RequestParam(value = "id", required = true) Integer id) {
		peopleService.deleteById(id);
		return new RedirectView("/people/list");
	}

}
