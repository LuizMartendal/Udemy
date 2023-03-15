package br.com.erudio.services;

import br.com.erudio.controllers.PersonController;
import br.com.erudio.dtos.person.PersonDTO;
import br.com.erudio.dtos.person.PersonDTOv2;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.models.PersonModel;
import br.com.erudio.repositories.PersonRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonDTO> findAll() {
        List<PersonModel> personModel = personRepository.findAll();
        List<PersonDTO> personDTO = new ArrayList<>();
        for (PersonModel person: personModel) {
            PersonDTO p = new PersonDTO();
            BeanUtils.copyProperties(person, p);
            p.add(linkTo(methodOn(PersonController.class).findById(p.getPersonId())).withSelfRel());
            personDTO.add(p);
        }
        return personDTO;
    }

    public PersonDTO findById(UUID id) {

        logger.info("Finding one person!");

        return personRepository.findById(id)
                .map(personModel -> {
                    PersonDTO personDTO = new PersonDTO();
                    BeanUtils.copyProperties(personModel, personDTO);
                    personDTO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
                    return personDTO;
                })
                .orElseThrow( () -> new ResourceNotFoundException("Person not found for id: " + id));
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Create one person!");
        if (personDTO != null) {
            PersonModel personModel = new PersonModel();
            BeanUtils.copyProperties(personDTO, personModel);
            personRepository.save(personModel);
            personDTO.add(linkTo(methodOn(PersonController.class).findById(personDTO.getPersonId())).withSelfRel());
            return personDTO;
        }
        throw new RequiredObjectIsNullException();
    }

    public PersonDTO update(PersonDTO personDTO, UUID id){
        logger.info("Updating one person!");
        return personRepository.findById(id)
                .map(person -> {
                    BeanUtils.copyProperties(personDTO, person);
                    personRepository.save(person);
                    personDTO.add(linkTo(methodOn(PersonController.class).findById(personDTO.getPersonId())).withSelfRel());
                    return personDTO;
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found for id: " + id));
    }

    public void delete(UUID id) {
        logger.info("Deleting one person!");

        personRepository.findById(id)
                .map(person -> {
                    personRepository.deleteById(id);
                    return "Person for id " + id + " has been deleted!";
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found for id: " + id));
    }

    public PersonDTOv2 createV2(PersonDTOv2 personDTOv2) {
        if (personDTOv2 != null) {
            PersonModel person = new PersonModel();
            BeanUtils.copyProperties(personDTOv2, person);
            personRepository.save(person);
            personDTOv2.add(linkTo(methodOn(PersonController.class).findById(personDTOv2.getKey())).withSelfRel());
            return personDTOv2;
        }
        throw new ResourceNotFoundException("There´s a problem with this person!");
    }
}
