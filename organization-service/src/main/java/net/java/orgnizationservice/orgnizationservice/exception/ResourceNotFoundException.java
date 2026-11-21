package net.java.orgnizationservice.orgnizationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException {
	public String resourceName;
	public String fieldName;
	public long fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fiendValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fiendValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fiendValue;
	}
}
