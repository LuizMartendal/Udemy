package io.github.Rique25.Vendas.controllers;

import io.github.Rique25.Vendas.exceptions.BadRequestException;
import io.github.Rique25.Vendas.models.Cliente;
import io.github.Rique25.Vendas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public Page<Cliente> getClientes(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                      @RequestParam(name = "size", defaultValue = "10") Integer size,
                                      @RequestParam(name = "direction", defaultValue = "asc") String direction)
    {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ?
                Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "nome"));
        return this.service.getClientes(pageable);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable UUID id) {
        if (id != null) {
            return this.service.getCliente(id);
        }
        throw new BadRequestException("É necessário fornecer um id para encontrar um cliente.");
    }

    @PostMapping
    public Cliente create(@Valid @RequestBody Cliente cliente) {
        if (cliente.getId() != null) {
            throw new BadRequestException("Não pode ser fornecido o id para criar um cliente.");
        }
        return this.service.create(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@Valid @RequestBody Cliente cliente, @PathVariable UUID id) {
        return this.service.update(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        System.out.println("deleted");
        this.service.delete(id);
    }
}
