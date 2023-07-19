package io.github.rique25.springbootcurso.repositories.person;

import io.github.rique25.springbootcurso.models.person.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, UUID> {
}
