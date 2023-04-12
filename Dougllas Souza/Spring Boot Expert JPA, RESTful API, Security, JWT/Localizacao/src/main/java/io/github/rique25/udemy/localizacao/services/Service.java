package io.github.rique25.udemy.localizacao.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface Service<T> {

    Page<T> findAll(Pageable pageable);

    T findById(UUID id);

    T save(T entity);

    T update(T entity, UUID id);

    void delete(T entity, UUID id);

}
