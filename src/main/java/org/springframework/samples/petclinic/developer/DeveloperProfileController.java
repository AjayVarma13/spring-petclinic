package org.springframework.samples.petclinic.developer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperProfileController {

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

}
