package br.com.erudio.restwithspringbootudemy.services.person;

import br.com.erudio.restwithspringbootudemy.controllers.person.PersonController;
import br.com.erudio.restwithspringbootudemy.dtos.person.PersonDTO;
import br.com.erudio.restwithspringbootudemy.models.person.PersonModel;
import br.com.erudio.restwithspringbootudemy.repositories.person.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<PersonDTO> findAll(Pageable pageable) {
        List<PersonDTO> personDTOS = new ArrayList<>();
        repository.findAll(pageable)
            .forEach(person -> {
                PersonDTO personDTO = new PersonDTO();
                BeanUtils.copyProperties(person, personDTO);
                personDTO.add(linkTo(methodOn(PersonController.class).findById(personDTO.getPersonId())).withSelfRel());
                personDTOS.add(personDTO);
            });
        return personDTOS;
    }

    public PersonDTO findById(Long id) {
        return repository.findById(id)
                .map(result -> {
                    PersonDTO personDTO = new PersonDTO();
                    BeanUtils.copyProperties(result, personDTO);
                    personDTO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
                    return personDTO;
                })
                .orElseThrow(() -> new RuntimeException("Person not found!"));
    }

    public PersonDTO create(PersonDTO person) {
        if (person == null) {
            throw new NullPointerException("Person is null");
        }
        PersonModel personModel = new PersonModel();
        BeanUtils.copyProperties(person, personModel);
        repository.save(personModel);
        person.add(linkTo(methodOn(PersonController.class).findById(person.getPersonId())).withSelfRel());
        return person;
    }

    public PersonDTO update(PersonDTO person) {
        if (person == null) {
            throw new NullPointerException("Person is null");
        }

        return repository.findById(person.getPersonId()).map(result -> {
            BeanUtils.copyProperties(person, result);
            repository.save(result);
            person.add(linkTo(methodOn(PersonController.class).findById(person.getPersonId())).withSelfRel());
            return person;
        }).orElseThrow(NullPointerException::new);
    }

    public void delete(Long id) {
        Optional<PersonModel> personFound = repository.findById(id);
        if (personFound.get().getPersonId() != null) {
            repository.delete(personFound.get());
        }
    }

    @Transactional
    public PersonDTO disablePerson(Long id) {
        return repository.findById(id)
                .map(person -> {
                    repository.disablePerson(person.getPersonId());
                    PersonDTO personDTO = new PersonDTO();
                    Optional<PersonModel> personModel = repository.findById(id);
                    BeanUtils.copyProperties(personModel, personDTO);
                    return personDTO;
                }).orElseThrow(NullPointerException::new);
    }
}
