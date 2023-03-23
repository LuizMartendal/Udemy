package br.com.erudio.restwithspringbootudemy.repositories.book;

import br.com.erudio.restwithspringbootudemy.models.book.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
}
