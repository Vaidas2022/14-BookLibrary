package lt.codeacademy.javau8.library;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.javau8.library.entities.Book;
import lt.codeacademy.javau8.library.services.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	BookService service;
	
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	
	@GetMapping("/all")
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	@PostMapping("/add")
	public Book saveBook(@RequestBody Book book) {
		return service.save(book);
	}
}
