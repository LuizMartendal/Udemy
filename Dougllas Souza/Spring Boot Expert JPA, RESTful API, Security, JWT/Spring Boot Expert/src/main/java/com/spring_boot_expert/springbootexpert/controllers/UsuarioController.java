package com.spring_boot_expert.springbootexpert.controllers;

import com.spring_boot_expert.springbootexpert.dtos.UsuarioDTO;
import com.spring_boot_expert.springbootexpert.models.UsuarioModel;
import com.spring_boot_expert.springbootexpert.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody @Valid UsuarioModel usuario) {
        return service.create(usuario);
    }
}
