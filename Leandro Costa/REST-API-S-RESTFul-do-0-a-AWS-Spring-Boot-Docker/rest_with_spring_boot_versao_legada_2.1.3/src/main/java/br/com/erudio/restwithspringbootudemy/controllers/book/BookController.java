package br.com.erudio.restwithspringbootudemy.controllers.book;

import br.com.erudio.restwithspringbootudemy.dtos.book.BookDTO;
import br.com.erudio.restwithspringbootudemy.services.book.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Books Endpoint")
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @ApiOperation(value = "Find all books")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<List<BookDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @ApiOperation(value = "Find book by id")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @ApiOperation(value = "Create a new book")
    @PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"},
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(service.create(bookDTO));
    }

    @ApiOperation(value = "Update a book")
    @PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"},
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok().body(service.update(bookDTO));
    }

    @ApiOperation(value = "Delete a book")
    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Book deleted!");
    }
}
