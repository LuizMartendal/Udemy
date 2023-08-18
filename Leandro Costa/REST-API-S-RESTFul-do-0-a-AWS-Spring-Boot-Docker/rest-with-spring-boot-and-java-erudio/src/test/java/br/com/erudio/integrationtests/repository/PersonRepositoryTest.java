package br.com.erudio.integrationtests.repository;

import br.com.erudio.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    PersonRepository personRepository;

    private static Person person;

    @BeforeAll
    public static void setup() {
        person = new Person();
    }

    @Order(0)
    @Test
    public void testFindPeopleById() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.ASC, "firstName"));
        person = personRepository.findPersonsByName("Ayr", pageable).getContent().get(0);
        Assertions.assertNotNull(person);
        Assertions.assertNotNull(person.getFirstName());
        Assertions.assertEquals("Ayrton", person.getFirstName());
    }

    @Order(1)
    @Test
    public void testDisablePersonById() {
        personRepository.disablePerson(person.getId());
        Optional<Person> person = personRepository.findById(this.person.getId());
        Assertions.assertNotNull(person);
        Assertions.assertFalse(person.get().getEnabled());
    }

}