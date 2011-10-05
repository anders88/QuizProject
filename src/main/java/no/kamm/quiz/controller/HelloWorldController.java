package no.kamm.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/hei")
	public String getHelloWorld(ModelMap map) {
		
		String attributeValue = "Jess!";
		map.addAttribute("navn", attributeValue);
		return "index";

	}

}
