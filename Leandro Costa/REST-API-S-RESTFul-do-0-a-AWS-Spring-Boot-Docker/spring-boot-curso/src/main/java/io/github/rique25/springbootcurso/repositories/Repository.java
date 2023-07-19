package io.github.rique25.springbootcurso.repositories;

import io.github.rique25.springbootcurso.utils.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@org.springframework.stereotype.Repository
public interface Repository<T> {

    @Transactional(readOnly = true)
    T retrieve(UUID id);

    @Transactional(readOnly = true)
    Page<T> list();
}
