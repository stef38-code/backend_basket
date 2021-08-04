package com.stephane.backend.basketball.components;

import com.stephane.backend.basketball.entities.constantes.Genre;
import com.stephane.backend.basketball.repository.PersonneRepository;
import com.stephane.backend.basketball.utils.data.JeuxDonnees;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** add données
 * **/
@Component
@RequiredArgsConstructor
@Slf4j
class DemoCommandLineRunner implements CommandLineRunner {
    private final PersonneRepository repository;
    private final JeuxDonnees jeuxDonnees = new JeuxDonnees();
    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(jeuxDonnees.getPersonneDirigeant(5));


        //U7 (Baby)  6 ans et moins
        repository.saveAll(jeuxDonnees.getU7(8, Genre.FEMININ));
        repository.saveAll(jeuxDonnees.getU7(5, Genre.MASCULIN));
        //U8-U9 (Mini-Poussins) 7 et 8 ans
        repository.saveAll(jeuxDonnees.getU9(5, Genre.FEMININ));
        repository.saveAll(jeuxDonnees.getU9(5, Genre.MASCULIN));
        //U10-U11 (Poussins)	9 et 10 ans
        repository.saveAll(jeuxDonnees.getU11(9, Genre.FEMININ));
        repository.saveAll(jeuxDonnees.getU11(5, Genre.MASCULIN));
        //U12-U13 (Benjamins)	11 et 12 ans
        repository.saveAll(jeuxDonnees.getU13(6, Genre.FEMININ));
        repository.saveAll(jeuxDonnees.getU13(9, Genre.MASCULIN));
        //U14-U15 (Minimes)	13 et 14 ans
        repository.saveAll(jeuxDonnees.getU15(6, Genre.FEMININ));
        repository.saveAll(jeuxDonnees.getU15(8, Genre.MASCULIN));
        //U16-U17 (Cadets)	15 et 16 ans
        repository.saveAll(jeuxDonnees.getU17(11, Genre.FEMININ));
        repository.saveAll(jeuxDonnees.getU17(7, Genre.MASCULIN));
        //U18-U19-U20 (Juniors) 	17,18,et 19 ans
        repository.saveAll(jeuxDonnees.getU18(9, Genre.FEMININ));
        repository.saveAll(jeuxDonnees.getU18(15, Genre.MASCULIN));

        repository.saveAll(jeuxDonnees.getPersonneJoueursMajeurSansFamille(8, Genre.FEMININ));
        repository.saveAll(jeuxDonnees.getPersonneJoueursMajeurSansFamille(14, Genre.MASCULIN));
    }

}
