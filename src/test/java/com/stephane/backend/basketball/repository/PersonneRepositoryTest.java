package com.stephane.backend.basketball.repository;

import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.entities.constantes.Genre;
import com.stephane.backend.basketball.entities.constantes.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
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
    @DisplayName("Test d'une personne")
    void testRepository_UnePersonne() {
        Personne personne = getPersonneEnfant();
        //Action
        Personne actual = repository.save(personne);
        log.info("Id de l'enfant {}", actual.getId());
        Optional<Personne> actualFind = repository.findById(actual.getId());
        repository.delete(actual);
        Optional<Personne> actualFind2 = repository.findById(actual.getId());
        //test
        assertThat(personne.isNew()).isFalse();
        assertAll("Test entity personne in DB",
                //controle si l'id existe
                () -> assertThat(actual.getId()).isNotNull().isNotBlank(),
                //test si nouvel enfant
                () -> assertThat(actual.isNew()).isFalse(),
                //controle l'enfant
                () -> assertThat(actualFind).hasValueSatisfying(o -> {
                    //controle les proprietes de l'enfant
                    assertThat(o)
                            .usingRecursiveComparison()
                            .isEqualTo(actual);
                }),
                () -> assertThat(actualFind2).isNotPresent());
    }

    @Test
    @Order(2)
    @DisplayName("Test deux personnes avec un lien famillial")
    void testRepository_DeuxPersonnes() {
        Personne enfant = getPersonneEnfant();
        Personne pere = getPersonneParent();
        enfant.getFamille().add(pere);
        //Action
        Personne actualPere = repository.save(pere);
        log.info("Id du pere {}", pere.getId());
        Personne actualEnfant = repository.save(enfant);
        log.info("Id de l'enfant {}", enfant.getId());
        Optional<Personne> actualFindEnfant = repository.findById(actualEnfant.getId());
        repository.delete(actualEnfant);
        Optional<Personne> actualFindEnfant2 = repository.findById(actualEnfant.getId());
        Optional<Personne> actualFindPere = repository.findById(actualPere.getId());
        //test
        assertAll("Test entity enfant in DB",
                //controle si l'id existe
                () -> assertThat(actualEnfant.getId()).isNotNull().isNotBlank(),
                //controle l'enfant
                () -> assertThat(actualFindEnfant).hasValueSatisfying(o -> {
                    //controle les proprietes de l'enfant
                    assertThat(o)
                            .usingRecursiveComparison()
                            .isEqualTo(actualEnfant);
                    //contient bien le pere
                    assertThat(o.getFamille()).contains(pere);
                }),
                //controle si l'enfant est bien supprime
                () -> assertThat(actualFindEnfant2).isNotPresent(),
                //controle si le pere existe apres la suppression de l'enfant
                () -> assertThat(actualFindPere).isPresent());
    }

    private Personne getPersonneEnfant() {
        Personne personne = Personne.builder()
                .nom("Marks")
                .prenom("Cleopatra")
                .datenaiss(LocalDate.of(2012, Month.JANUARY, 8))
                .genre(Genre.FEMININ)
                .role(Role.ENFANT)
                .famille(new HashSet<>())
                .activites(new HashSet<>())
                .build();
        return personne;
    }

    private Personne getPersonneParent() {
        Personne personne = Personne.builder()
                .nom("Marks")
                .prenom("Robert")
                .datenaiss(LocalDate.of(1980, Month.JANUARY, 8))
                .genre(Genre.MASCULIN)
                .role(Role.PERE)
                .famille(new HashSet<>())
                .activites(new HashSet<>())
                .build();
        return personne;
    }
}