package lt.codeacademy.javau8.library.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lt.codeacademy.javau8.library.entities.Book;
import lt.codeacademy.javau8.library.services.BookService;

@Controller
public class BookController {

	private static final Logger log = LoggerFactory.getLogger(ApiController.class);

	BookService service;
	
	public BookController (BookService service) {
		this.service = service;
	}
	
    @GetMapping("/add")
    public String showSignUpForm(Book book) {
        return "add-book";
    }
    
    @PostMapping("/addbook")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        
        service.save(book);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showBookList(Model model) {
        model.addAttribute("books", service.getAllBooks()  );
        return "index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = service.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        
        model.addAttribute("book", book);
        return "update-book";
    }
}
