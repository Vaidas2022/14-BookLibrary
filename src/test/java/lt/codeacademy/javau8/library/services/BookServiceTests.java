package lt.codeacademy.javau8.library.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import lt.codeacademy.javau8.library.entities.Book;
import lt.codeacademy.javau8.library.repositories.BookRepository;

public class BookServiceTests {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllBooksTest() {
        Book book1 = new Book();
        Book book2 = new Book();
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.getAllBooks();

        assertEquals(2, books.size());
        verify(bookRepository).findAll();
    }

    @Test
    public void saveBookTest() {
        Book book = new Book(); 
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.save(book);

        assertEquals(book, savedBook);
        verify(bookRepository).save(book);
    }

    @Test
    public void findByIdTest() {
        long bookId = 1024L;
        Optional<Book> optionalBook = Optional.of(new Book()); 
        when(bookRepository.findById(bookId)).thenReturn(optionalBook);

        Optional<Book> foundBook = bookService.findById(bookId);

        assertEquals(optionalBook, foundBook);
        verify(bookRepository).findById(bookId);
    }

    @Test
    public void deleteBookTest() {
        Book book = new Book(); 

        bookService.delete(book);

        verify(bookRepository).delete(book);
    }
}
