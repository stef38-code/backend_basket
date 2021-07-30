package com.stephane.backend.basketball.utils.data;

import com.stephane.backend.basketball.entities.ActiviteDansLeClub;
import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.entities.constantes.Categorie;
import com.stephane.backend.basketball.entities.constantes.Genre;
import com.stephane.backend.basketball.entities.constantes.Role;

import java.util.HashSet;

public class JeuxDonneesPersonnes extends JeuxDonneesContacts {

  protected Personne getPersonneMajeur(Role role, Genre genre, Categorie categorie) {
    return getPersonne(18, 65, genre, role, categorie);
  }

  protected Personne getPersonneMineur(int minAge, int maxAge, Genre genre, Categorie categorie) {
    Personne personne = getPersonne(minAge, maxAge, genre, Role.ENFANT, categorie);
    personne.setActiviteDansLeClub(
        ActiviteDansLeClub.builder()
            .joueur(true)
            .arbitre(false)
            .dirigeant(false)
            .entraineur(false)
            .build());
    return personne;
  }

  private Personne getPersonne(
      int minAge, int maxAge, Genre genre, Role role, Categorie categorie) {
    return Personne.builder()
        .nom(faker.name().lastName())
        .prenom(faker.name().firstName())
        .datenaiss(convertToLocalDateViaInstant(faker.date().birthday(minAge, maxAge)))
        .genre(genre)
        .role(role)
        .categorie(categorie)
        .famille(new HashSet<>())
        .adresses(new HashSet<>())
        .contacts(new HashSet<>())
        .build();
  }
}
