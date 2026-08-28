package org.springframework.samples.petclinic.developer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.developer.entity.Developer;
import org.springframework.samples.petclinic.developer.service.DeveloperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperProfileController {

	private final DeveloperService developerService;

	public DeveloperProfileController(DeveloperService developerService) {
		this.developerService = developerService;
	}

	@GetMapping("/profile")
	public Map<String, Object> getExperiencedDeveloperProfile() {
		Map<String, Object> profile = new LinkedHashMap<>();

		profile.put("title", "Senior Associate - Java Backend Engineer");
		profile.put("experienceYears", 3);

		// Core technical stack expected at a 3-year mid-level tier
		profile.put("coreCompetencies", List.of("Java 17/21", "Spring Boot", "Spring Data JPA", "RESTful API Design"));
		profile.put("databaseExpertise", List.of("PostgreSQL", "MySQL", "H2 Database"));
		profile.put("testingTools", List.of("JUnit 5", "Mockito"));
		profile.put("devOpsTools", List.of("Maven", "Docker", "Git/GitHub Actions"));

		profile.put("architectureStyle", "Layered Architecture / Microservices");
		profile.put("status", "Active Contribution Mode");

		return profile;
	}

	@PostMapping("/developer")
	public Map<String, String> createDeveloper(@RequestBody Map<String, String> request) {

		Map<String, String> create = new LinkedHashMap<>();

		create.put("name", request.get("name"));
		create.put("skill", request.get("skill"));
		create.put("status", "Developer created successfully");

		return create;

	}

	@PostMapping
	public Developer createDeveloperUsingJpa(@RequestBody Developer developer) {
		return this.developerService.save(developer);
	}

	@GetMapping
	public List<Developer> getDevelopers() {
		return this.developerService.findAll();
	}

	@GetMapping("/{id}")
	public Developer getDeveloperById(@PathVariable Long id) {
		return this.developerService.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDeveloper(@PathVariable Long id) {

		this.developerService.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public Developer updateDeveloper(@PathVariable Long id, @RequestBody Developer developer) {

		return this.developerService.updateDeveloper(id, developer);
	}

}
