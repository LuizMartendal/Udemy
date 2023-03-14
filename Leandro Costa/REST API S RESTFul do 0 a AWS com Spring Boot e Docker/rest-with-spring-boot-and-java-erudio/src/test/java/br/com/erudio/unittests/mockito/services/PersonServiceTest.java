package br.com.erudio.unittests.mockito.services;

import br.com.erudio.dtos.PersonDTO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.models.PersonModel;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    PersonDTO person;
    @Mock
    PersonRepository personRepository;

    @InjectMocks
    private PersonService service;

    @BeforeEach
    void setUp() {
        person = new PersonDTO();
        MockitoAnnotations.openMocks(this);
    }

    private void setPerson() {
        person.setId(UUID.fromString("c6218679-9744-4bf8-a87f-c546b34bcf36"));
        person.setName("Luiz");
        person.setAdress("Rua Pedro Martendal");
        person.setLastName("Martendal");
        person.setGender("Male");
    }

    @Test
    void ExceptionTest() {

    }

    @Test
    void findAll() {
        List<PersonModel> personModelList = new ArrayList<>();
        when(personRepository.findAll()).thenReturn(personModelList);

        PersonModel personModel = new PersonModel();
        when(personRepository.save(personModel)).thenReturn(personModel);

        BeanUtils.copyProperties(person, personModel);
        service.create(person);

        var result = service.findAll();

        assertNotNull(result);
    }

    @Test
    void findById() {
        this.setPerson();

        PersonModel personModel = new PersonModel();
        BeanUtils.copyProperties(person, personModel);
        personModel.setId(person.getId());
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(personModel));

        PersonDTO result = service.findById(person.getId());
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
    }

    @Test
    void create() {
        this.setPerson();

        PersonModel personModel = new PersonModel();
        BeanUtils.copyProperties(person, personModel);
        when(personRepository.save(personModel)).thenReturn(personModel);

        PersonDTO result = service.create(person);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
    }

    @Test
    void update() {
        this.setPerson();

        PersonModel personModel = new PersonModel();

        BeanUtils.copyProperties(person, personModel);
        when(personRepository.findById(personModel.getId())).thenReturn(Optional.of(personModel));

        PersonDTO personDTO = service.findById(personModel.getId());
        assertNotNull(personDTO);
        assertNotNull(personDTO.getPersonId());

        personModel.setName("Samara dos");
        personModel.setLastName("Anjos");
        when(personRepository.save(personModel)).thenReturn(personModel);

        PersonDTO personDTO1 = new PersonDTO();
        BeanUtils.copyProperties(personModel, personDTO1);
        var result = service.update(personDTO1, personDTO1.getId());
        var resultFound = service.findById(personDTO1.getId());

        assertNotNull(result);
        assertNotNull(result.getPersonId());

        assertEquals(result.getName(), resultFound.getName());
        assertNotEquals(resultFound.getName(), personDTO.getName());
    }

    @Test
    void delete() {
        PersonModel personModel = new PersonModel();

        BeanUtils.copyProperties(person, personModel);

        when(personRepository.save(personModel)).thenReturn(personModel);
        when(personRepository.findById(personModel.getId())).thenReturn(Optional.of(personModel));

        var result = service.create(person);

        var result1 = service.findById(personModel.getId());

        assertEquals(result1.getName(), result.getName());
        assertEquals(result.getName(), person.getName());

        service.delete(result1.getId());

        var result2 = service.findById(result1.getId());

        assertNull(result2.getName());
    }

}