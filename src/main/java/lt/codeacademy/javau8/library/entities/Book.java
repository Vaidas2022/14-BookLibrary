package lt.codeacademy.javau8.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@NotBlank(message = "Title is mandatory")
	String title;
	
	@NotBlank(message = "Author is mandatory")
	String author;
	
	@NotBlank(message = "Year is mandatory")
	String year;
	
	public Book() {}

	public Book(Long id, String title, String author, String year) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	public Book(String title, String author, String year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return title + ", " + author + "[" + year + "]";
	}
	
	
}
