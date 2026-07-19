package org.springframework.samples.petclinic.developer;

import org.springframework.samples.petclinic.developer.service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeveloperUiController {

	private final DeveloperService developerService;

	public DeveloperUiController(DeveloperService developerService) {
		this.developerService = developerService;
	}

	@GetMapping("/developers")
	public String showDevelopers(Model model) {

		model.addAttribute("developers", this.developerService.findAll());

		return "developers/list";
	}

}