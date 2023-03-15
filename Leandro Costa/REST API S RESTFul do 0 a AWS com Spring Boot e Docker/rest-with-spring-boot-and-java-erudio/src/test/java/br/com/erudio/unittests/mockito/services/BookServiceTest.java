package br.com.erudio.unittests.mockito.services;

import br.com.erudio.dtos.books.BookDTO;
import br.com.erudio.models.BookModel;
import br.com.erudio.repositories.BookRepository;
import br.com.erudio.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    BookDTO bookDTO;

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookDTO = new BookDTO();
        MockitoAnnotations.openMocks(this);
    }

    private void setBookDTO() {
        bookDTO.setAuthor("Luiz Henrique Martendal");
        bookDTO.setLaunchDate(LocalDate.of(2023,3,14));
        bookDTO.setPrice(250.50);
        bookDTO.setTitle("Java Spring Boot");
        bookDTO.setId(UUID.fromString("3f9a95bc-f1e0-4a13-8fb6-469e51d3cae1"));
    }

    @Test
    void findAll() {
        this.setBookDTO();
    }

    @Test
    void findById() {
        this.setBookDTO();
    }

    @Test
    void create() {
        this.setBookDTO();
    }

    @Test
    void update() {
        this.setBookDTO();
    }

    @Test
    void delete() {
        this.setBookDTO();
    }
}