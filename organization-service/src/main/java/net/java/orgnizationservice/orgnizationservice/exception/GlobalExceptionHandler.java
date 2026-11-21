package net.java.orgnizationservice.orgnizationservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false), "ORGANIZATION_NOT_FOUND");
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
}
