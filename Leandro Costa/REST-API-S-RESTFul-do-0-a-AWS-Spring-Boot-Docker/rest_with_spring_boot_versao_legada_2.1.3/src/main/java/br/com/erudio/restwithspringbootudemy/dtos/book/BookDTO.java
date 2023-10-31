package br.com.erudio.restwithspringbootudemy.dtos.book;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BookDTO extends ResourceSupport implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idBook;
    private String author;
    private Date launchDate;
    private double price;
    private String title;

    public BookDTO() {
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long bookId) {
        this.idBook = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDTO)) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Double.compare(bookDTO.getPrice(), getPrice()) == 0 && Objects.equals(getIdBook(), bookDTO.getIdBook()) && Objects.equals(getAuthor(), bookDTO.getAuthor()) && Objects.equals(getLaunchDate(), bookDTO.getLaunchDate()) && Objects.equals(getTitle(), bookDTO.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBook(), getAuthor(), getLaunchDate(), getPrice(), getTitle());
    }
}
