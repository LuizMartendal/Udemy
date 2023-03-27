package br.com.erudio.restwithspringbootudemy.controllers.person;

import br.com.erudio.restwithspringbootudemy.dtos.person.PersonDTO;
import br.com.erudio.restwithspringbootudemy.services.person.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Person Endpoint")
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @ApiOperation(value = "Find all people")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PagedResources<Resource<PersonDTO>>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                      @RequestParam(value = "size", defaultValue = "12") int size,
                                                                      @RequestParam(value = "direction", defaultValue = "acs") String direction,
                                                                      PagedResourcesAssembler<PersonDTO> assembler)
    {
        Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "firstName"));
        return ResponseEntity.status(HttpStatus.OK).body(assembler.toResource(service.findAll(pageable)));
    }

    @ApiOperation(value = "Find person by id")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @ApiOperation(value = "Create a person")
    @PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"},
                produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personModel) {
        return ResponseEntity.ok().body(service.create(personModel));
    }

    @ApiOperation(value = "Update a person")
    @PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"},
                produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO personModel) {
        return ResponseEntity.ok().body(service.update(personModel));
    }

    @ApiOperation(value = "Disable a person")
    @PatchMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
                  value = "/{id}")
    public ResponseEntity<PersonDTO> disablePerson(@PathVariable Long id) {
        return ResponseEntity.ok(service.disablePerson(id));
    }

    @ApiOperation(value = "Delete a person")
    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Person deleted!");
    }
}
