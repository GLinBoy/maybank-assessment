package com.glinboy.test.maybank.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResponseStatusExceptionAdvice extends ResponseEntityExceptionHandler  {

	@ExceptionHandler({ ResponseStatusException.class })
	public ResponseEntity<Map<String, String>> handle(ResponseStatusException e) {
		Map<String, String> error = new HashMap<>();
		error.put("error_description", e.getReason());
		if (e.getCause() != null)
			error.put("error", e.getCause().getMessage());
		else
			error.put("error", "");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");

		return new ResponseEntity<>(error, headers, e.getStatus());
	}

}