package io.github.rique25.udemy.localizacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Repository<T> extends JpaRepository<T, UUID> {
}
