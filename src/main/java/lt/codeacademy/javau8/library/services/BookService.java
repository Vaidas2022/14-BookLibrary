package lt.codeacademy.javau8.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau8.library.entities.Book;
import lt.codeacademy.javau8.library.repositories.BookRepository;

@Service
public class BookService {

	BookRepository repo;
	
	public BookService(BookRepository repo) {
		this.repo = repo;
	}
	
	public List<Book> getAllBooks(){
		return repo.findAll();
	}

	public Book save(Book book) {
		return repo.save(book);	
	}

	public Optional<Book> findById(long id) {
		
		return repo.findById(id);
	}
	
}
