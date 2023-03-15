package br.com.erudio.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "person")
public class PersonModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID personId;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "lastName", nullable = false, length = 80)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String adress;

    @Column(nullable = false, length = 10)
    private String gender;

    public PersonModel() { }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID id) {
        this.personId = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonModel that = (PersonModel) o;
        return Objects.equals(personId, that.personId) && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(adress, that.adress) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, lastName, adress, gender);
    }
}
