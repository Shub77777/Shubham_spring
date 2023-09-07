package com.example.bat.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bat.entity.Books;

public interface BooksDBrepo extends JpaRepository <Books ,Long>{

}
