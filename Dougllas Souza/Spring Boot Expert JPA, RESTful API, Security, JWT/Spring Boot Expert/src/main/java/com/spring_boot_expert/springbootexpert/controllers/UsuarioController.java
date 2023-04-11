package com.spring_boot_expert.springbootexpert.controllers;

import com.spring_boot_expert.springbootexpert.dtos.CredentialsDTO;
import com.spring_boot_expert.springbootexpert.dtos.TokenDTO;
import com.spring_boot_expert.springbootexpert.dtos.UsuarioDTO;
import com.spring_boot_expert.springbootexpert.exceptions.SenhaInvalidaException;
import com.spring_boot_expert.springbootexpert.jwt.JwtService;
import com.spring_boot_expert.springbootexpert.models.UsuarioModel;
import com.spring_boot_expert.springbootexpert.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService service;
    private final JwtService jwtService;

    public UsuarioController(UsuarioService usuarioService, JwtService jwtService) {
        this.service = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody @Valid UsuarioModel usuario) {
        return service.create(usuario);
    }

//    @PostMapping("/auth")
//    public TokenDTO autenticar(@RequestBody CredentialsDTO credenciais) {
//        try {
//            UserDetails usuario = service.autenticar(credenciais);
//            String token = jwtService.gerarToken(usuario);
//            return new TokenDTO(usuario.getUsername(), token);
//        } catch (UsernameNotFoundException unfe) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, unfe.getMessage());
//        } catch (SenhaInvalidaException sie) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sie.getMessage());
//        }
//    }
}
