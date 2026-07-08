package org.springframework.samples.petclinic.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.developer.entity.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}