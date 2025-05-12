package com.example.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.librarysystem.domain.Book;
import com.example.librarysystem.service.BookService;

@Controller
public class BookController {


	@Autowired
	private BookService bookService;

	//initial loading page
	@GetMapping("/")
	public String showAddBookForm(Model model) {
		List<Book> bookList = bookService.listBookAll();
		model.addAttribute("books", bookList);
		return "index"; 
	}

	@GetMapping("/books")
    public String listBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Book> books;

        // Check if a keyword is provided for search
        if (keyword != null && !keyword.isEmpty()) {
            books = bookService.listAll(keyword);
        } else {
            books = bookService.listBookAll();
        }
        model.addAttribute("books", books);
        return "index";
    }
	
	// Show the form to add a new book
    @GetMapping("/books/register")
    public String addBookForm(Model model) {
    	Book book = new Book();
        
        if (book.getYear() == 0) {
            book.setYear(0); 
        }
    	model.addAttribute("book", new Book()); 
        return "add-book"; 
    }

    // Save the new book
    @PostMapping("/books/register")
    public String saveNewBook(@ModelAttribute Book book) {
        bookService.saveBook(book); 
        return "redirect:/books"; 
    }
	
	@GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable("id") int id, Model model) throws Exception {
		Book book = bookService.getBookById(id); 
	    if (book == null) {
	        throw new Exception("Book not found with ID: " + id);
	    }
	    model.addAttribute("book", book);
	    return "edit-book"; 
    }

    @PostMapping("/edit")
    public String updateBook(@ModelAttribute Book book,Model model) {
    	List<Book> bookList = bookService.listBookAll();
		model.addAttribute("books", bookList);
        bookService.updateBook(book); 
        return "index"; 
    }
    
    
    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id); 
        return "index"; 
    }
    
    // Display book details
    @GetMapping("/book/details/{id}")
    public String getBookDetails(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "index";
        }
        model.addAttribute("book", book);
        return "detail-book";
    }

}
