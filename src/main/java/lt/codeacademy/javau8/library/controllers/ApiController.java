package lt.codeacademy.javau8.library.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.javau8.library.entities.Book;
import lt.codeacademy.javau8.library.services.BookService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private static final Logger log = LoggerFactory.getLogger(ApiController.class);

	BookService service;
	
	
	public ApiController(BookService service) {
		this.service = service;
	}
	
	
	@GetMapping("/all")
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	@PostMapping("/add")
	public Book saveBook(@RequestBody Book book) {
		log.debug(book.toString());
		return service.save(book);
	}
}
