package lt.codeacademy.javau8.library.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;


import lt.codeacademy.javau8.library.entities.Book;
import lt.codeacademy.javau8.library.services.BookService;

public class ApiEndpointsTests {
	
	private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private ApiController apiController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }
	
    @Test
    public void testEndpointGetAllBooks() throws Exception {
        Book book1 = new Book(); 
        Book book2 = new Book();
        List<Book> books = Arrays.asList(book1, book2);

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/api/all"))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$", hasSize(2)));
    }
}
