package br.com.erudio.controllers;

import br.com.erudio.dtos.books.BookDTO;
import br.com.erudio.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> findAll() {
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(bookService.create(bookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO bookDTO, @PathVariable UUID id) {
        return ResponseEntity.ok().body(bookService.update(bookDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted!");
    }
}
