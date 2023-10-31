package br.com.erudio.restwithspringbootudemy.models.book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "books")
public class BookModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBook;
    @Column(length = 100)
    private String author;
    @Column(nullable = false)
    private Date lauchDate;
    @Column(nullable = false, length = 65)
    private double price;
    @Column(nullable = false, length = 200)
    private String title;

    public BookModel() {
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

    public Date getLauchDate() {
        return lauchDate;
    }

    public void setLauchDate(Date lauchDate) {
        this.lauchDate = lauchDate;
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
        if (!(o instanceof BookModel)) return false;
        BookModel bookModel = (BookModel) o;
        return Double.compare(bookModel.getPrice(), getPrice()) == 0 && Objects.equals(getIdBook(), bookModel.getIdBook()) && Objects.equals(getAuthor(), bookModel.getAuthor()) && Objects.equals(getLauchDate(), bookModel.getLauchDate()) && Objects.equals(getTitle(), bookModel.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBook(), getAuthor(), getLauchDate(), getPrice(), getTitle());
    }
}
