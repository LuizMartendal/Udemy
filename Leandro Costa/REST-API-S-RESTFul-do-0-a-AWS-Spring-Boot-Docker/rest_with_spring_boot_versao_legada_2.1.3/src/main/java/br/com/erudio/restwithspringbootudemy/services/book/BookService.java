package br.com.erudio.restwithspringbootudemy.services.book;

import br.com.erudio.restwithspringbootudemy.controllers.book.BookController;
import br.com.erudio.restwithspringbootudemy.dtos.book.BookDTO;
import br.com.erudio.restwithspringbootudemy.models.book.BookModel;
import br.com.erudio.restwithspringbootudemy.repositories.book.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<BookDTO> findAll() {
        List<BookDTO> bookDTOs = new ArrayList<>();
        repository.findAll()
                .forEach(books -> {
                    BookDTO bookDTO = new BookDTO();
                    BeanUtils.copyProperties(books, bookDTO);
                    bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getIdBook())).withSelfRel());
                    bookDTOs.add(bookDTO);
                });
        return bookDTOs;
    }

    public BookDTO findById(Long id) {
        return repository.findById(id)
                .map(result -> {
                    BookDTO bookDTO = new BookDTO();
                    BeanUtils.copyProperties(result, bookDTO);
                    bookDTO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
                    return bookDTO;
                })
                .orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    public BookDTO create(BookDTO bookDTO) {
        if (bookDTO == null) {
            throw new NullPointerException("Person is null");
        }
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(bookDTO, bookModel);
        repository.save(bookModel);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getIdBook())).withSelfRel());
        return bookDTO;
    }

    public BookDTO update(BookDTO bookDTO) {
        if (bookDTO == null) {
            throw new NullPointerException("Person is null");
        }

        return repository.findById(bookDTO.getIdBook()).map(result -> {
            BeanUtils.copyProperties(bookDTO, result);
            repository.save(result);
            bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getIdBook())).withSelfRel());
            return bookDTO;
        }).orElseThrow(NullPointerException::new);
    }

    public void delete(Long id) {
        Optional<BookModel> bookFound = repository.findById(id);
        if (bookFound.get().getIdBook() != null) {
            repository.delete(bookFound.get());
        }
    }
}
