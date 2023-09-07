package com.example.bat.service;




import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bat.entity.Books;
import com.example.bat.exception.BooksNotFoundException;
import com.example.bat.repository.BooksDBrepo;
import com.example.bat.repository.Booksrepo;


@Service
public class Booksservice {
	
	@Autowired
	BooksDBrepo repo;
	
	public List<Books> findAll(Pageable pageable){
		
		return repo.findAll(pageable).toList();
	}
	
	public Books findByID(long id) {
		
		Optional<Books> b = repo.findById(id);
		return b.orElseThrow(() -> new BooksNotFoundException("BOOK NOT FOUND" +id));
	}
	
    public Books updateBooks(long id,Books book) {
		
    	Books b1 =findByID(id);
    	b1.setAuthor(book.getAuthor());
    	b1.setTitle(book.getTitle());
    	b1.setPublished(book.isPublished());
    	repo.save(b1);
		return b1;
	}
    
    public Books addBooks(Books b) {
		
		return repo.save(b);
	}
    
    public void deleteBooks(long id) {
		Books b=findByID(id);
		
		repo.delete(b);
	}
	

}


