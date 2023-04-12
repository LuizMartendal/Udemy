package io.github.rique25.udemy.localizacao.repositories.cidade;

import io.github.rique25.udemy.localizacao.models.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpec {

    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, cb) -> cb.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> habitantesGreaterThan(Long habitantes) {
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), habitantes);
    }
}
