package com.example.bat.exception;

public class BooksNotFoundException extends RuntimeException {
	public BooksNotFoundException(String message) {
		super(message);
	}

}
