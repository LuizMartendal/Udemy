package br.com.erudio.restwithspringbootudemy.repositories.person;

import br.com.erudio.restwithspringbootudemy.models.person.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel,Long> {

    @Modifying
    @Query("UPDATE PersonModel p SET p.enabled = false WHERE p.personId =:id")
    void disablePerson(@Param("id") Long id);
}
