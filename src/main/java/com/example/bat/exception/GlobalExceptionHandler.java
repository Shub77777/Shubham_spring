package com.example.bat.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BooksNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleBookNotFoundException(BooksNotFoundException ex){
		
		ErrorDetails error = new ErrorDetails();
		error.setMessage(ex.getMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setDatetime(LocalDateTime.now());
		
		ResponseEntity<ErrorDetails> res = new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
			return res;
	}

}
