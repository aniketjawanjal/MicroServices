package com.net.java.employeeservices.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException {

	private String resourceName;
	private String fieldName;
	private long fiendValue;
	public ResourceNotFoundException(String resourceName, String fieldName, long fiendValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fiendValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fiendValue = fiendValue;
	}
	
	
	
}
