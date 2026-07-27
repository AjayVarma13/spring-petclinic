package org.springframework.samples.petclinic.developer.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DeveloperNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleDeveloperNotFound(DeveloperNotFoundException ex, Model model) {

		model.addAttribute("message", ex.getMessage());

		return "developers/error";
	}

}