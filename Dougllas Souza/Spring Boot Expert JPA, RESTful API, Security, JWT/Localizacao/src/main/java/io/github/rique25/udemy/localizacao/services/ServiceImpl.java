package io.github.rique25.udemy.localizacao.services;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public abstract class ServiceImpl<T> implements Service<T> {

    public abstract JpaRepository<T, UUID> getRepository();

    public abstract T getEntity();

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public T findById(UUID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new NullPointerException(getEntity().getClass().getName() + " não encontrado(a)!"));
    }

    @Override
    @Transactional
    public T save(T entity) {
        if (entity == null) {
            throw new NullPointerException(getEntity().getClass().getName() + " não pode ser null");
        }
        return getRepository().save(entity);
    }

    @Override
    @Transactional
    public T update(T entity, UUID id) {
        return getRepository().findById(id)
                .map(entityFound -> {
                    BeanUtils.copyProperties(entity, entityFound);
                    return getRepository().save(entityFound);
                }).orElseThrow(() -> new NullPointerException(getEntity().getClass().getName() + " não encontrado(a)"));
    }

    @Override
    @Transactional
    public void delete(T entity, UUID uuid) {
        T e = getRepository().findById(uuid)
                .orElseThrow(() -> new NullPointerException(getEntity().getClass().getName() + " não encontrado(a)"));
        if (e.equals(entity)) {
            getRepository().delete(entity);
        }
    }
}
