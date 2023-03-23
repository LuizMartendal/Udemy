package br.com.erudio.restwithspringbootudemy.controllers.person;

import br.com.erudio.restwithspringbootudemy.dtos.person.PersonDTO;
import br.com.erudio.restwithspringbootudemy.services.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<List<PersonDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"},
                produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personModel) {
        return ResponseEntity.ok().body(service.create(personModel));
    }

    @PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"},
                produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO personModel) {
        return ResponseEntity.ok().body(service.update(personModel));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Person deleted!");
    }
}
