package br.com.erudio.restwithspringbootudemy.repositories.person;

import br.com.erudio.restwithspringbootudemy.models.person.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel,Long> {
}
