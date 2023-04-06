package com.spring_boot_expert.springbootexpert.repositories;

import com.spring_boot_expert.springbootexpert.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

    Optional<UsuarioModel> findByUsuario(String usuario);
}
