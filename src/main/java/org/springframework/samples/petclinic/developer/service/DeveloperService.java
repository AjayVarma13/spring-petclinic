package org.springframework.samples.petclinic.developer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.samples.petclinic.developer.entity.Developer;
import org.springframework.samples.petclinic.developer.repository.DeveloperRepository;

@Service
public class DeveloperService {

	private final DeveloperRepository developerRepository;

	public DeveloperService(DeveloperRepository developerRepository) {
		this.developerRepository = developerRepository;
	}

	public Developer save(Developer developer) {
		return this.developerRepository.save(developer);
	}

	public List<Developer> findAll() {
		return this.developerRepository.findAll();
	}

	public Developer findById(Long id) {
		return this.developerRepository.findById(id).orElse(null);
	}

	public void deleteById(Long id) {
		this.developerRepository.deleteById(id);
	}

	public Developer updateDeveloper(Long id, Developer developer) {

		Developer existingDeveloper = this.developerRepository.findById(id).orElse(null);

		if (existingDeveloper == null) {
			return null;
		}

		existingDeveloper.setName(developer.getName());
		existingDeveloper.setSkill(developer.getSkill());

		return this.developerRepository.save(existingDeveloper);
	}

}