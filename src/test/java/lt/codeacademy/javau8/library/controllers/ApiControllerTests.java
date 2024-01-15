package lt.codeacademy.javau8.library.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lt.codeacademy.javau8.library.entities.Book;
import lt.codeacademy.javau8.library.services.BookService;

public class ApiControllerTests {

    @Mock
    private BookService bookService;

    private ApiController apiController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        apiController = new ApiController(bookService);
    }

    @Test
    void testGetAllBooks() {
        Book book1 = new Book();
        Book book2 = new Book();
        List<Book> expectedBooks = Arrays.asList(book1, book2);

        when(bookService.getAllBooks())
        	.thenReturn(expectedBooks);

        List<Book> actualBooks = apiController.getAllBooks();

        assertEquals(expectedBooks, actualBooks, "Turėtų grąžinti visus knygas");
    }
    
    @Test
    void testSaveBook() {
        Book newBook = new Book();
        Book savedBook = new Book(); 

        when(bookService.save(any(Book.class)))
        	.thenReturn(savedBook);

        Book result = apiController.saveBook(newBook);

        assertEquals(savedBook, result, "Turėtų grąžinti išsaugotą knygą");
    }
    

}