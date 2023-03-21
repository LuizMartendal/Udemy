package br.com.erudio.integrationtests.vo.person;

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
    private PersonEmbeddedVO personEmbeddedVO;

    public WrapperPersonVO() {
    }

    public PersonEmbeddedVO getPersonEmbeddedVO() {
        return personEmbeddedVO;
    }

    public void setPersonEmbeddedVO(PersonEmbeddedVO personEmbeddedVO) {
        this.personEmbeddedVO = personEmbeddedVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrapperPersonVO that)) return false;
        return Objects.equals(getPersonEmbeddedVO(), that.getPersonEmbeddedVO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonEmbeddedVO());
    }
}
