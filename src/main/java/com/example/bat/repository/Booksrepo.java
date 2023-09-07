package com.example.bat.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.bat.entity.Books;
import com.example.bat.exception.BooksNotFoundException;

@Repository

public class Booksrepo {
	
		
		List<Books> book = new ArrayList<>();
		
		public Booksrepo() {
			
			book.add (new Books(1,"TTTTTTTTTTT","SATTU",true));
			book.add (new Books(2,"RRRRRRRRRRR","RAM",true));
			book.add (new Books(3,"SSSSSSSSSSS","SOHAM",true));
		}
		
		public List<Books> findAll(){
			
			return book;
		}
		public Books findByID(long id) {
			Optional<Books> b = book.stream().
					filter((bo)  -> bo.getId()==id).
					findAny();
			return b.orElseThrow(() -> new BooksNotFoundException("BOOK NOT FOUND"));
		}
		
		public Books addBooks(Books bo) {
			book.add(bo);
			return bo;
		}
		public Books updateBooks(long id,Books bo) {
			Books book1=findByID(id);
			book1.setAuthor(bo.getAuthor());
			book1.setAuthor(bo.getTitle());
			book1.setPublished(bo.isPublished());
			return book1;
		}
		
		public void deleteBook(long id) {
			Books book1 = findByID(id);
			book.remove(book1);
		}

	

}
