package io.github.rique25.springbootcurso.models.person;

import io.github.rique25.springbootcurso.models.ModelImpl;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class PersonModel extends ModelImpl implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonModel(UUID id, String createdBy, String updatedBy, Date createdIn, Date updatedIn, String firstName, String lastName, String address, String gender) {
        super(id, createdBy, updatedBy, createdIn, updatedIn);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public PersonModel(String firstName, String lastName, String address, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
