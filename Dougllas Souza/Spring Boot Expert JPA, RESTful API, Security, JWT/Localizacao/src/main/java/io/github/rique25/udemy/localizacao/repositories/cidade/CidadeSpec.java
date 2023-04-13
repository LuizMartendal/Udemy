package io.github.rique25.udemy.localizacao.repositories.cidade;

import io.github.rique25.udemy.localizacao.models.Cidade;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.UUID;

public abstract class CidadeSpec {

    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, cb) -> cb.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> idEqual(UUID id) {
        return (root, query, cb) -> cb.equal(root.get("id"), id);
    }

    public static Specification<Cidade> habitantesGreaterThan(Long habitantes) {
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), habitantes);
    }

    public static Specification<Cidade> habitantesBetwenn(Long min, Long max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("habitantes"), min, max);
    }

    public static Specification<Cidade> nomeLike(String nome) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%" + nome + "%".toUpperCase());
    }

    public static Specification<Cidade> filtroDinamico(Cidade filtro) {
        Specification<Cidade> spec = Specification.where((root, query, cb) -> cb.conjunction());

        if (filtro.getId() != null) {
            spec = spec.and(idEqual(filtro.getId()));
        }

        if (StringUtils.hasText(filtro.getNome())) {
            spec = spec.and(nomeLike(filtro.getNome()));
        }

        if (filtro.getHabitantes() != null) {
            spec = spec.and(habitantesGreaterThan(filtro.getHabitantes()));
        }

        return spec;
    }
}
