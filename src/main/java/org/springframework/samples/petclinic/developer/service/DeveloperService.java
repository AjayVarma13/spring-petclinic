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

}