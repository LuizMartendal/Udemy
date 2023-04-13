package io.github.rique25.udemy.localizacao.repositories.cidade;

import io.github.rique25.udemy.localizacao.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, UUID> {

    Optional<List<Cidade>> findByNome(String nome);

    Optional<List<Cidade>> findByNomeStartingWith(String nome);

    @Query(" SELECT c FROM Cidade c WHERE UPPER(c.nome) like UPPER(:nome)")
    Optional<List<Cidade>> findByNomeLikeManual(String nome);

    Optional<List<Cidade>> findByNomeLike(String nome);

    Optional<List<Cidade>> findByNomeEndingWith(String nome);

    Optional<List<Cidade>> findByNomeContaining(String nome);

    Optional<List<Cidade>> findByHabitantes(Long habitantes);

    Optional<List<Cidade>> findByHabitantesLessThan(Long habitantes);

    Optional<List<Cidade>> findByHabitantesGreaterThan(Long habitantes);

    Optional<List<Cidade>> findByHabitantesLessThanEqual(Long habitantes);

    Optional<List<Cidade>> findByHabitantesLessThanEqualAndNomeLike(Long habitantes, String nome);
 }
