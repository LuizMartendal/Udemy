package br.com.erudio.services;

import br.com.erudio.models.PersonModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonModel> findAll() {
        List<PersonModel> people = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PersonModel person = mockPerson(i);
            people.add(person);
        }
        return people;
    }

    private PersonModel mockPerson(int i) {
        PersonModel person = new PersonModel();

        logger.info("Finding all people!");

        person.setId(counter.incrementAndGet());
        person.setName("Name " + i);
        person.setLastName("LastName " + i);
        person.setAdress("Adress " + i);
        person.setGender("Gender " + i);

        return person;
    }

    public PersonModel findById(String id) {

        logger.info("Finding one person!");

        return mockPerson(1);
    }

    public PersonModel create(PersonModel personModel) {
        logger.info("Create one person!");

        return personModel;
    }

    public PersonModel update(PersonModel personModel){
        logger.info("Updating one person!");

        return personModel;
    }

    public void delete(String id) {
        logger.info("Deleting one person!");
    }
}
