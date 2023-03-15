package br.com.erudio.controllers;

import br.com.erudio.dtos.person.PersonDTO;
import br.com.erudio.dtos.person.PersonDTOv2;
import br.com.erudio.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/person")
@Tag(name = "People", description = "Endpoints for managing people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Find", description = "Find all people")
    public ResponseEntity<List<PersonDTO>> findAll() {
        return ResponseEntity.ok().body(personService.findAll());
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Find", description = "Find a person by Id")
    public ResponseEntity<PersonDTO> findById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Create", description = "Create a person")
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person) {
        return ResponseEntity.ok().body(personService.create(person));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                value = "/v2")
    @Operation(summary = "Create V2", description = "Create a person V2")
    public ResponseEntity<PersonDTOv2> createV2(@RequestBody PersonDTOv2 person) {
        return ResponseEntity.ok().body(personService.createV2(person));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                value = "/{id}")
    @Operation(summary = "Update", description = "Update person´s data")
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person, @PathVariable UUID id) {
        return ResponseEntity.ok().body(personService.update(person, id));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete", description = "Delete a person by Id")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Success deleted!");
    }
}
