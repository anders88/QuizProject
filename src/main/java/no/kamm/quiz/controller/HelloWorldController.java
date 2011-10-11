package no.kamm.quiz.controller;

import no.kamm.quiz.people.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@Autowired
	private PeopleService peopleService;

	@RequestMapping("/find")
	public String getHelloWorld(ModelMap map) {
		map.addAttribute("navn", peopleService.getPerson().getUsername());
		return "index";
	}

	@RequestMapping("/count")
	public String getPeopleCount(ModelMap map) {
		map.addAttribute("navn", peopleService.getPeopleCount());
		return "index";
	}

}
