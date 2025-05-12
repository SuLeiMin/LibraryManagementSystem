package com.example.librarysystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarysystem.domain.Book;
import com.example.librarysystem.repository.BookRepository;

@Service
public class BookService {

	 @Autowired
	 private BookRepository bookRepository;
	 
	 public List<Book> listBookAll(){
		 return bookRepository.findAll();
	 }
	 
	 public List<Book> listAll(String keyword){
		 return bookRepository.findByTitleContainingIgnoreCase(keyword);
	 }
	 
	 public Book getBookById(int id) {
		    Optional<Book> userOptional = bookRepository.findById((long) id);
		    if(userOptional.isPresent()) {
		        return userOptional.get();
		    }
		    return null; // or throw a custom exception
		}
	 
	 // Save a new book
	    public void saveBook(Book book) {
	        bookRepository.save(book);
	    }
	    
	  public void updateBook(Book book) {
	        bookRepository.save(book); // Save or update the book
	    }
	 
	  public void deleteBookById(long id) {
	        if (bookRepository.existsById(id)) {
	            bookRepository.deleteById(id); // Delete the book if it exists
	        } else {
	            throw new IllegalArgumentException("Book with ID " + id + " not found");
	        }
	    }
}
