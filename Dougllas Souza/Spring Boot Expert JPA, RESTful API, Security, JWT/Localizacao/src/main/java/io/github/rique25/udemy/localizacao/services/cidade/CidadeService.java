package io.github.rique25.udemy.localizacao.services.cidade;

import io.github.rique25.udemy.localizacao.models.Cidade;
import io.github.rique25.udemy.localizacao.repositories.cidade.CidadeRepository;
import io.github.rique25.udemy.localizacao.services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CidadeService extends ServiceImpl<Cidade> {

    @Autowired
    private CidadeRepository repository;

    @Override
    public JpaRepository<Cidade, UUID> getRepository() {
        return repository;
    }

    @Override
    public Cidade getEntity() {
        return new Cidade();
    }

    Optional<List<Cidade>> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    Optional<List<Cidade>> findByNomeStartingWith(String nome) {
        return repository.findByNomeStartingWith(nome);
    }

    Optional<List<Cidade>> findByNomeLikeManual(String nome) {
        return repository.findByNomeLikeManual(nome);
    }

    Optional<List<Cidade>> findByNomeLike(String nome) {
        return repository.findByNomeLike(nome);
    }

    Optional<List<Cidade>> findByNomeEndingWith(String nome) {
        return repository.findByNomeEndingWith(nome);
    }

    Optional<List<Cidade>> findByNomeContaining(String nome) {
        return repository.findByNomeContaining(nome);
    }

    Optional<List<Cidade>> findByHabitantes(Long habitantes) {
        return repository.findByHabitantes(habitantes);
    }

    Optional<List<Cidade>> findByHabitantesLessThan(Long habitantes) {
        return repository.findByHabitantesLessThan(habitantes);
    }

    Optional<List<Cidade>> findByHabitantesGreaterThan(Long habitantes) {
        return repository.findByHabitantesGreaterThan(habitantes);
    }

    Optional<List<Cidade>> findByHabitantesLessThanEqual(Long habitantes) {
        return repository.findByHabitantesLessThanEqual(habitantes);
    }

    Optional<List<Cidade>> findByHabitantesLessThanEqualAndNomeLike(Long habitantes, String nome) {
        return repository.findByHabitantesLessThanEqualAndNomeLike(habitantes, nome);
    }

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, exampleMatcher);
        return repository.findAll(example);
    }
}
