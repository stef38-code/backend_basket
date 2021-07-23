package com.stephane.backend.basketball.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonneTest {
    @Test
    public void testCanEqual() {
        Personne personneOther = new Personne();
        personneOther.setNom("2Qxh");
        assertThat((new Personne())).isNotEqualTo(personneOther);
    }

    @Test
    public void testCanEqual2() {
        Personne personne = new Personne();

        Personne personne1 = new Personne();
        personne1.setPrenom("Prenom");
        personne1.setFamille(new HashSet<Personne>());
        personne1.setNom("Nom");
        personne1.setRole(Role.PERE);
        personne1.setGenre(Genre.MASCULIN);
        personne1.setDatenaiss(LocalDate.of(1980, Month.JANUARY, 8));
        assertThat(personne.canEqual(personne1)).isTrue();
    }

    @Test
    public void testConstructor() {
        Personne actualPersonne = new Personne();
        LocalDate ofEpochDayResult = LocalDate.of(1980, Month.JANUARY, 8);
        actualPersonne.setDatenaiss(ofEpochDayResult);
        HashSet<Personne> personneSet = new HashSet<>();
        String id = "7ad398d5-09c7-49df-beac-6bae556c20a3";
        String user = "Mertz";
        Date date = Date.from(ofEpochDayResult.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        actualPersonne.setCreatedBy(user);
        actualPersonne.setLastModifiedBy(user);
        actualPersonne.setCreationDate(date);
        actualPersonne.setLastModifiedDate(date);
        actualPersonne.setId(id);

        actualPersonne.setFamille(personneSet);
        actualPersonne.setGenre(Genre.MASCULIN);

        actualPersonne.setNom("Nom");
        actualPersonne.setPrenom("Prenom");
        actualPersonne.setRole(Role.PERE);


        assertThat(actualPersonne.getDatenaiss()).isSameAs(ofEpochDayResult);
        assertThat(actualPersonne.getFamille()).isSameAs(personneSet);
        assertThat(actualPersonne.getGenre()).isEqualTo(Genre.MASCULIN);
        assertThat(actualPersonne.getId()).isNotBlank().isEqualTo(id);
        assertThat(actualPersonne.getCreatedBy()).isNotBlank().isEqualTo(user);
        assertThat(actualPersonne.getLastModifiedBy()).isNotBlank().isEqualTo(user);
        assertThat(actualPersonne.getCreationDate()).isSameAs(date);
        assertThat(actualPersonne.getLastModifiedDate()).isSameAs(date);
        assertThat(actualPersonne.isNew()).isFalse();
        assertThat(actualPersonne.getNom()).isEqualTo("Nom");
        assertThat(actualPersonne.getPrenom()).isEqualTo("Prenom");
        assertThat(actualPersonne.getRole()).isEqualTo(Role.PERE);
        assertThat(actualPersonne.toString()).isEqualTo("Personne(nom=Nom, prenom=Prenom, datenaiss=1980-01-08, genre=MASCULIN, role=PERE, activites=[], famille=[])");
    }

    @Test
    public void testNotEqualsWithNullPerson() {
        Personne personne = new Personne();
        personne.setPrenom("Prenom");
        personne.setFamille(new HashSet<>());
        personne.setNom("Nom");
        personne.setRole(Role.PERE);
        personne.setGenre(Genre.MASCULIN);
        personne.setDatenaiss(LocalDate.of(1980, Month.JANUARY, 8));
        assertThat(personne.equals(null)).isFalse();
    }

    @Test
    public void testNotEquals() {
        Personne personne = new Personne();
        personne.setPrenom("Prenom");
        personne.setFamille(new HashSet<>());
        personne.setNom("42");
        personne.setRole(Role.PERE);
        personne.setGenre(Genre.MASCULIN);
        personne.setDatenaiss(LocalDate.ofEpochDay(1L));

        Personne personne1 = new Personne();
        personne1.setPrenom("Prenom");
        personne1.setFamille(new HashSet<>());
        personne1.setNom("Nom");
        personne1.setRole(Role.PERE);
        personne1.setGenre(Genre.MASCULIN);
        personne1.setDatenaiss(LocalDate.ofEpochDay(1L));
        assertThat(personne.equals(personne1)).isFalse();
    }

    @Test
    public void testEquals() {
        Personne personne = new Personne();
        personne.setPrenom("Prenom");
        personne.setNom(null);
        personne.setRole(Role.PERE);
        personne.setGenre(Genre.MASCULIN);
        personne.setDatenaiss(LocalDate.of(1980, Month.JANUARY, 8));

        assertThat(personne.equals(personne)).isTrue();


    }
    @Test
    public void testDuilderToString() {
        String personneToString = Personne.builder()
                .nom("Marks")
                .prenom("Cleopatra")
                .datenaiss(LocalDate.of(2012, Month.JANUARY, 8))
                .genre(Genre.FEMININ)
                .role(Role.ENFANT)
                .famille(new HashSet<>())
                .activites(new HashSet<>())
                .build().toString();
        assertThat(personneToString).isNotBlank().isEqualTo("Personne(nom=Marks, prenom=Cleopatra, datenaiss=2012-01-08, genre=FEMININ, role=ENFANT, activites=[], famille=[])");

    }
}

