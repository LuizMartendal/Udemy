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
    private boolean enabled;
    private String gender;
    private String address;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO)) return false;
        if (!super.equals(o)) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return isEnabled() == personDTO.isEnabled() && Objects.equals(getPersonId(), personDTO.getPersonId()) && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getGender(), personDTO.getGender()) && Objects.equals(getAddress(), personDTO.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPersonId(), getFirstName(), getLastName(), isEnabled(), getGender(), getAddress());
    }
}
