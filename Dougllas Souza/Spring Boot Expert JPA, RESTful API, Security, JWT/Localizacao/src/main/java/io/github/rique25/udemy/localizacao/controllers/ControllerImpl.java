package io.github.rique25.udemy.localizacao.controllers;

import io.github.rique25.udemy.localizacao.services.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public abstract class ControllerImpl<T> implements Controller<T> {

    public abstract Service<T> getService();

    @Override
    @ResponseStatus(HttpStatus.OK)
    public Page<T> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size,
                           @RequestParam(name = "direction", defaultValue = "ASC") String direction)
    {
        Sort.Direction d = direction.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction));
        return getService().findAll(pageable);
    }

    @Override
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T findById(@PathVariable UUID id) {
        return getService().findById(id);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public T create(T entity) {
        return getService().save(entity);
    }

    @Override
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T update(T entity, @PathVariable UUID id) {
        return getService().update(entity, id);
    }

    @Override
    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(T entity, @PathVariable UUID id) {
        getService().delete(entity, id);
    }
}
