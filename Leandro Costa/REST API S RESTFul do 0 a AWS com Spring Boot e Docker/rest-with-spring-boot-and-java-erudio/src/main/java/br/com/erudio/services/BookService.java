package br.com.erudio.services;

import br.com.erudio.controllers.BookController;
import br.com.erudio.dtos.books.BookDTO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.models.BookModel;
import br.com.erudio.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<BookDTO> findAll() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<BookModel> bookModelList = bookRepository.findAll();

        bookModelList.forEach(book -> {
            var bookDTO = new BookDTO();
            BeanUtils.copyProperties(book, bookDTO);
            bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getId())).withSelfRel());
            bookDTOList.add(bookDTO);
        });
        return bookDTOList;
    }

    public BookDTO findById(UUID id) {
        BookModel bookModel = bookRepository.findById(id)
                .orElseThrow(RequiredObjectIsNullException::new);
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(bookModel, bookDTO);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getId())).withSelfRel());
        return bookDTO;
    }

    public BookDTO create(BookDTO bookDTO) {
        if (bookDTO == null) throw new RequiredObjectIsNullException();

        var book = new BookModel();
        BeanUtils.copyProperties(bookDTO, book);
        bookRepository.save(book);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getId())).withSelfRel());
        return bookDTO;
    }

    public BookDTO update(BookDTO bookDTO, UUID id) {
        if (bookDTO.getId() != id) throw new IllegalArgumentException();

        var book = bookRepository.findById(id)
                .orElseThrow(RequiredObjectIsNullException::new);
        BeanUtils.copyProperties(bookDTO, book);
        bookRepository.save(book);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(bookDTO.getId())).withSelfRel());
        return bookDTO;
    }

    public void delete(UUID id) {
        bookRepository.findById(id)
                .map(bookModel -> {
                    bookRepository.delete(bookModel);
                    return "Book has been deleted!";
                }).orElseThrow(RequiredObjectIsNullException::new);
    }
}
