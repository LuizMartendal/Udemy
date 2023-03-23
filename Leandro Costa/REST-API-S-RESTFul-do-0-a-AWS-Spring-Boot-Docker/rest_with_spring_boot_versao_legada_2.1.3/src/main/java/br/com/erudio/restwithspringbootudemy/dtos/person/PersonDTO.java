package br.com.erudio.restwithspringbootudemy.dtos.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "lastName", "firstName", "gender"})
public class PersonDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long personId;
    private String firstName;
    private String lastName;
    private String gender;
    private String adress;

    public PersonDTO() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO)) return false;
        if (!super.equals(o)) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(getPersonId(), personDTO.getPersonId()) && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getGender(), personDTO.getGender()) && Objects.equals(getAdress(), personDTO.getAdress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPersonId(), getFirstName(), getLastName(), getGender(), getAdress());
    }
}
