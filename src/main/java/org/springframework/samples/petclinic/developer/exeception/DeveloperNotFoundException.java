package org.springframework.samples.petclinic.developer.exception;

public class DeveloperNotFoundException extends RuntimeException {

	public DeveloperNotFoundException(String message) {
		super(message);
	}

}
