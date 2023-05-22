package io.github.Rique25.Vendas.controllers;

import io.github.Rique25.Vendas.dtos.AuthenticationDTO;
import io.github.Rique25.Vendas.dtos.TokenDTO;
import io.github.Rique25.Vendas.exceptions.BadRequestException;
import io.github.Rique25.Vendas.jwt.JwtTokenProvider;
import io.github.Rique25.Vendas.models.Usuario;
import io.github.Rique25.Vendas.repositories.UsuarioRepository;
import io.github.Rique25.Vendas.services.UsuarioService;
import jakarta.validation.Valid;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@Valid @RequestBody Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }


    @PostMapping("/login")
    public TokenDTO login(@RequestBody AuthenticationDTO user) {
        Usuario usuario = usuarioRepository.getByUsuario(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        if (usuario == null) {
            throw new BadCredentialsException("Usuário ou senha incorretos!");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        return  jwtTokenProvider.createAccessToken(usuario, Arrays.asList(usuario.getPerfil().getPerfil()));
    }
}
