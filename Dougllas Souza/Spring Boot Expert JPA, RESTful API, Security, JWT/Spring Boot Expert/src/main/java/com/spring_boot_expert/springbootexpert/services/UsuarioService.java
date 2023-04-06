package com.spring_boot_expert.springbootexpert.services;

import com.spring_boot_expert.springbootexpert.dtos.UsuarioDTO;
import com.spring_boot_expert.springbootexpert.models.UsuarioModel;
import com.spring_boot_expert.springbootexpert.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsuarioModel usuario = repository.findByUsuario(s)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
        String[] roles = usuario.isAdmin() ?
                new String[] {"ADMIN", "USER}"} : new String[] {"USER"};
        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(roles)
                .build();
    }

    @Transactional
    public UsuarioDTO create(UsuarioModel usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        UsuarioModel usuarioModel = repository.save(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(usuarioModel, usuarioDTO);
        return usuarioDTO;
    }
}
