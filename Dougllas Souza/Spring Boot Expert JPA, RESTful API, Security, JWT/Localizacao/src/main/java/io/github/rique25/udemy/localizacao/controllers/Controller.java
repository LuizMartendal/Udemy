package io.github.rique25.udemy.localizacao.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface Controller<T> {

    Page<T> findAll(int page, int size, String direction);

    T findById(UUID id);

    T create (T entity);

    T update(T entity, UUID id);

    void delete(T entity, UUID id);
}
