package com.stephane.backend.basketball.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActivitesTest {
    private Activites activites = new Activites();
    @Test
    public void testCanEqual() {
        assertThat(activites.canEqual("Other")).isFalse();
    }



    @Test
    public void testConstructor() {
        Activites actualActivites = new Activites();
        actualActivites.setId("42");
        actualActivites.setLibelle("Libelle");
        actualActivites.setNom("Nom");
        assertThat(actualActivites.getId()).isEqualTo("42");
        assertThat(actualActivites.getLibelle()).isEqualTo("Libelle");
        assertThat(actualActivites.getNom()).isEqualTo("Nom");
        assertThat(actualActivites.toString()).isEqualTo("Activites(id=42, nom=Nom, libelle=Libelle)");
    }

    @Test
    public void testEquals_false() {
        Activites activites = new Activites();
        activites.setId("42");
        activites.setNom("Nom");
        activites.setLibelle("Libelle");
        assertThat(activites.equals(null)).isFalse();
    }
    @Test
    public void testCanEqual_true() {
        Activites activites = new Activites();

        Activites activites1 = new Activites();
        activites1.setId("42");
        activites1.setNom("Nom");
        activites1.setLibelle("Libelle");
        assertThat(activites.canEqual(activites1)).isTrue();
    }

    @Test
    public void testEquals_false_2() {
        Activites activites = new Activites();
        activites.setId("42");
        activites.setNom("Nom");
        activites.setLibelle(null);

        Activites activites1 = new Activites();
        activites1.setId("42");
        activites1.setNom("Nom");
        activites1.setLibelle("Libelle");
        assertThat(activites.equals(activites1)).isFalse();
    }

    @Test
    public void testEquals_hashCode_true() {
        Activites activites = new Activites();
        activites.setId(null);
        activites.setNom("Nom");
        activites.setLibelle("Libelle");

        Activites activites1 = new Activites();
        activites1.setId(null);
        activites1.setNom("Nom");
        activites1.setLibelle("Libelle");
        assertThat(activites.equals(activites1)).isTrue();
        int expectedHashCodeResult = activites.hashCode();
        assertThat(activites1.hashCode()).isEqualTo(expectedHashCodeResult);
    }


    @Test
    public void testEquals_hashCode_false() {
        Activites activites = new Activites();
        activites.setId("42");
        activites.setNom("Nom");
        activites.setLibelle("42");

        Activites activites1 = new Activites();
        activites1.setId("42");
        activites1.setNom("Nom");
        activites1.setLibelle("Libelle");
        assertThat(activites.equals(activites1)).isFalse();
        int expectedHashCodeResult = activites.hashCode();
        assertThat(activites1.hashCode()).isNotEqualTo(expectedHashCodeResult);
    }
}

