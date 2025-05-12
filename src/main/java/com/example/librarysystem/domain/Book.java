package com.example.librarysystem.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String title;


	private String author;



	private int year;


	private String genre;

	// Default constructor
	public Book() {
	}

	public Book(int id,String title, String author, int year, String genre) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
	}


	// Parameterized constructor
	public Book(String title, String author, int year, String genre) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// Override toString method
	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", year=" + year +
				", genre='" + genre + '\'' +
				'}';
	}
}