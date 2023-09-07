package com.example.bat.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bat.entity.Books;
import com.example.bat.service.Booksservice;


@RestController
@RequestMapping("/api/v1/books")
public class Bookscontroller {
    
	@Autowired
	Booksservice service;
	//http://localhost:9090/api/v1/books
	@GetMapping
	public ResponseEntity<List<Books>> getfindAll(Pageable pageable){
		return new ResponseEntity<List<Books>>(service.findAll(pageable),HttpStatus.OK);
	}
	
	//http://localhost:9090/api/v1/books/1
	@GetMapping("/{id}")
	public ResponseEntity<Books> findById(@PathVariable long id){
		return new ResponseEntity<Books>(service.findByID(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Books> updateBooks(@RequestBody Books bo){
		return new ResponseEntity<Books>(service.addBooks(bo ),HttpStatus.CREATED);
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<Books> updateBooks(@RequestBody Books bo,@PathVariable("id") Long boId){
		return new ResponseEntity<Books>(service.updateBooks(boId ,bo ),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delById(@PathVariable("id") Long Id) {
		service.deleteBooks(Id);
		return "Deleted Successfully";
	}
}
