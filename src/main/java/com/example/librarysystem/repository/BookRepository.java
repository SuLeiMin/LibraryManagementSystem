package com.example.librarysystem.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarysystem.domain.Book;

public interface BookRepository  extends JpaRepository<Book, Long>{

	 List<Book> findByTitleContainingIgnoreCase(String keyword);
}
