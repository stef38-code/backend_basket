package com.stephane.backend.basketball.repository;

import com.stephane.backend.basketball.entities.Genre;
import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.entities.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonneRepositoryTest {
    @Autowired
    PersonneRepository repository;

    @Test
    @Order(1)
    @DisplayName("Test entity personne in DB")
    void testRepository_Person() {
        Personne personne = new Personne();
        personne.setNom("Marks");
        personne.setPrenom("Cleopatra");
        personne.setDatenaiss(LocalDate.of(2012, Month.JANUARY, 8));
        personne.setGenre(Genre.FEMININ);
        personne.setRole(Role.ENFANT);
        //Action
        Personne actual = repository.save(personne);
        Optional<Personne> actualFind = repository.findById(actual.getId());
        repository.delete(actual);
        Optional<Personne> actualFind2 = repository.findById(actual.getId());
        //test
        assertAll("Test entity personne in DB",
                () -> assertThat(actual.getId()).isNotNull().isNotBlank(),
                () -> assertThat(actualFind).hasValueSatisfying(o -> {
                    assertThat(o)
                            .usingRecursiveComparison()
                            .isEqualTo(actual);
                }),
        ()-> assertThat(actualFind2).isNotPresent());
    }
}