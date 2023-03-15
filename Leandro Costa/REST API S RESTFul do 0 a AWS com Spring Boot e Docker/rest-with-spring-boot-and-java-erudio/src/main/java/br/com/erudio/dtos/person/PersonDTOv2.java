package br.com.erudio.dtos.person;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class PersonDTOv2 extends RepresentationModel<PersonDTOv2> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private UUID personId;
    private String name;
    private String lastName;
    private String adress;
    private String gender;
    private Date birthDate;

    public UUID getKey() {
        return personId;
    }

    public void setKey(UUID key) {
        this.personId = key;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
