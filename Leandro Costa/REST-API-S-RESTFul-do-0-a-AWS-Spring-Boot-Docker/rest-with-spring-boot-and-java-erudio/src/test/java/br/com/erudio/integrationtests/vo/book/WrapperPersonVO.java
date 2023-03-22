package br.com.erudio.integrationtests.vo.book;

import br.com.erudio.integrationtests.vo.person.PersonEmbeddedVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
public class WrapperPersonVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("_embedded")
    private BookEmbeddedVO bookEmbeddedVO;

    public WrapperPersonVO() {
    }

    public BookEmbeddedVO getBookEmbeddedVO() {
        return bookEmbeddedVO;
    }

    public void setPersonEmbeddedVO(BookEmbeddedVO bookEmbeddedVO) {
        this.bookEmbeddedVO = bookEmbeddedVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrapperPersonVO that)) return false;
        return Objects.equals(getBookEmbeddedVO(), that.getBookEmbeddedVO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookEmbeddedVO());
    }
}
