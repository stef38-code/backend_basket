package com.stephane.backend.basketball.entities;

import java.time.LocalDate;
import java.time.Month;
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
        personne1.setDatenaiss(LocalDate.ofEpochDay(1L));
        assertThat(personne.canEqual(personne1)).isTrue();
    }

    @Test
    public void testConstructor() {
        Personne actualPersonne = new Personne();
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualPersonne.setDatenaiss(ofEpochDayResult);
        HashSet<Personne> personneSet = new HashSet<>();
        actualPersonne.setFamille(personneSet);
        actualPersonne.setGenre(Genre.MASCULIN);
        actualPersonne.setNom("Nom");
        actualPersonne.setPrenom("Prenom");
        actualPersonne.setRole(Role.PERE);
        assertThat(actualPersonne.getDatenaiss()).isSameAs(ofEpochDayResult);
        assertThat(actualPersonne.getFamille()).isSameAs(personneSet);
        assertThat(actualPersonne.getGenre()).isEqualTo(Genre.MASCULIN);
        assertThat(actualPersonne.getId()).isBlank();
        assertThat(actualPersonne.isNew()).isTrue();
        assertThat(actualPersonne.getNom()).isEqualTo("Nom");
        assertThat(actualPersonne.getPrenom()).isEqualTo("Prenom");
        assertThat(actualPersonne.getRole()).isEqualTo(Role.PERE);
        assertThat(actualPersonne.toString()).isEqualTo("Personne(nom=Nom, prenom=Prenom, datenaiss=1970-01-02, genre=MASCULIN, role=PERE, activites=[], famille=[])");
    }

    @Test
    public void testNotEqualsWithNullPerson() {
        Personne personne = new Personne();
        personne.setPrenom("Prenom");
        personne.setFamille(new HashSet<>());
        personne.setNom("Nom");
        personne.setRole(Role.PERE);
        personne.setGenre(Genre.MASCULIN);
        personne.setDatenaiss(LocalDate.ofEpochDay(1L));
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

}

