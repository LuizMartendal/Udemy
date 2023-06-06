package com.rique25.agenda.controllers;

import com.rique25.agenda.models.Contato;
import com.rique25.agenda.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public Contato save( @RequestBody Contato contato ) {
        return this.contatoService.save(contato);
    }

    @PutMapping("{id}")
    public Contato update( @RequestBody Contato contato, @PathVariable String id ) {
        UUID uuid = UUID.fromString(id);
        return this.contatoService.update(uuid, contato);
    }

    @PatchMapping("{id}/favorito")
    public Contato setFavorito(@PathVariable String id, @RequestParam(name = "favorito", defaultValue = "false") Boolean favorito) {
        return this.contatoService.setFavorito(UUID.fromString(id), favorito);
    }

    @GetMapping
    public Page<Contato> list( @RequestParam(name = "page", defaultValue = "0") Integer page,
                               @RequestParam(name = "size", defaultValue = "10") Integer size,
                               @RequestParam(name = "direction", defaultValue = "asc") String direction)
    {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "nome"));
        return this.contatoService.list(pageable);
    }

    @GetMapping("{id}")
    public Contato findById( @PathVariable String id ) {
        return this.contatoService.findById(UUID.fromString(id));
    }
}
