package com.stephane.backend.basketball.components;

import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.entities.constantes.Genre;
import com.stephane.backend.basketball.entities.constantes.Role;
import com.stephane.backend.basketball.repository.PersonneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;

/** add données
 * **/
@Component
@RequiredArgsConstructor
@Slf4j
class DemoCommandLineRunner implements CommandLineRunner {
    private final PersonneRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Personne enfant = getPersonneEnfant();
        Personne pere = getPersonneParent();
        enfant.getFamille().add(pere);
        //Action
        Personne actualPere = repository.save(pere);
        log.info("Id du pere {}", actualPere.getId());
        Personne actualEnfant = repository.save(enfant);
        log.info("Id de l'enfant {}", actualEnfant.getId());
    }
    private Personne getPersonneEnfant() {
        return Personne.builder()
                .nom("Marks")
                .prenom("Cleopatra")
                .datenaiss(LocalDate.of(2012, Month.JANUARY, 8))
                .genre(Genre.FEMININ)
                .role(Role.ENFANT)
                .famille(new HashSet<>())
                .activites(new HashSet<>())
                .build();
    }

    private Personne getPersonneParent() {
        return Personne.builder()
                .nom("Marks")
                .prenom("Robert")
                .datenaiss(LocalDate.of(1980, Month.JANUARY, 8))
                .genre(Genre.MASCULIN)
                .role(Role.PERE)
                .famille(new HashSet<>())
                .activites(new HashSet<>())
                .build();

    }
}
