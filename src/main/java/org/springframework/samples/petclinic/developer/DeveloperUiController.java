package org.springframework.samples.petclinic.developer;

import org.springframework.samples.petclinic.developer.service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.samples.petclinic.developer.entity.Developer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping("/developers/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {

		Developer developer = this.developerService.findById(id);

		model.addAttribute("developer", developer);

		return "developers/edit";
	}

	@PostMapping("/developers/update/{id}")
	public String updateDeveloper(@PathVariable Long id, Developer developer) {

		this.developerService.updateDeveloper(id, developer);

		return "redirect:/developers";
	}

	@GetMapping("/developers/new")
	public String showCreateForm(Model model) {

		model.addAttribute("developer", new Developer());

		return "developers/create";
	}

	@PostMapping("/developers")
	public String saveDeveloper(Developer developer) {

		this.developerService.save(developer);

		return "redirect:/developers";
	}

	@GetMapping("/developers/delete/{id}")
	public String deleteDeveloper(@PathVariable Long id) {

		this.developerService.deleteById(id);

		return "redirect:/developers";
	}

}