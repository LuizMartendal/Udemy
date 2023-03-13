package br.com.erudio.unittests.mockito.services;

import br.com.erudio.dtos.PersonDTO;
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

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
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

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        UUID id = UUID.fromString("c6218679-9744-4bf8-a87f-c546b34bcf36");
        person.setId(id);
        person.setName("Luiz");
        person.setAdress("Rua Pedro Martendal");
        person.setLastName("Martendal");
        person.setGender("Male");

        PersonModel personModel = new PersonModel();
        BeanUtils.copyProperties(person, personModel);
        personModel.setId(person.getId());
        when(personRepository.findById(id)).thenReturn(Optional.of(personModel));

        PersonDTO result = service.findById(id);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void createV2() {
    }
}