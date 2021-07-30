package com.stephane.backend.basketball.utils.data;

import com.stephane.backend.basketball.entities.ActiviteDansLeClub;
import com.stephane.backend.basketball.entities.Adresse;
import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.entities.constantes.Categorie;
import com.stephane.backend.basketball.entities.constantes.Genre;
import com.stephane.backend.basketball.entities.constantes.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class JeuxDonnees extends JeuxDonneesPersonnes {

  public List<Personne> getPersonneJoueursMajeurSansFamille(int nombre, Genre genre) {
    List<Personne> list = new ArrayList<>();
    for (int i = 0; i < nombre; i++) {
      Personne personneMajeur = getPersonneMajeur(Role.ADULTE, genre, Categorie.SENIOR);
      personneMajeur.setFamille(new HashSet<>());
      personneMajeur.setAdresses(Collections.singleton(getAdresse()));
      personneMajeur.setContacts(getContacts());
      personneMajeur.setActiviteDansLeClub(
          ActiviteDansLeClub.builder()
              .joueur(true)
              .arbitre(false)
              .dirigeant(false)
              .entraineur(false)
              .build());
      list.add(personneMajeur);
    }
    return list;
  }

  public List<Personne> getPersonneDirigeant(int nombre) {
    List<Personne> list = new ArrayList<>();
    for (int i = 0; i < nombre; i++) {
      Personne personneDirigeante =
          Personne.builder()
              .nom(faker.name().lastName())
              .prenom(faker.name().firstName())
              .datenaiss(convertToLocalDateViaInstant(faker.date().birthday()))
              .genre(randomEnum(Genre.class))
              .activiteDansLeClub(
                  ActiviteDansLeClub.builder()
                      .joueur(false)
                      .arbitre(false)
                      .dirigeant(true)
                      .entraineur(false)
                      .build())
              .role(Role.ADULTE)
              .famille(new HashSet<>())
              .adresses(Collections.singleton(getAdresse()))
              .contacts(getContacts())
              .build();
      list.add(personneDirigeante);
    }
    return list;
  }

  public List<Personne> getU7(int nombre, Genre genre) {
    return getPersonneJoueurMineur(nombre, 5, 6, genre, Categorie.U7);
  }

  public List<Personne> getU9(int nombre, Genre genre) {
    return getPersonneJoueurMineur(nombre, 7, 8, genre, Categorie.U9);
  }

  public List<Personne> getU11(int nombre, Genre genre) {
    return getPersonneJoueurMineur(nombre, 9, 10, genre, Categorie.U11);
  }

  public List<Personne> getU13(int nombre, Genre genre) {
    return getPersonneJoueurMineur(nombre, 11, 12, genre, Categorie.U13);
  }

  public List<Personne> getU15(int nombre, Genre genre) {
    return getPersonneJoueurMineur(nombre, 13, 14, genre, Categorie.U15);
  }

  public List<Personne> getU17(int nombre, Genre genre) {
    return getPersonneJoueurMineur(nombre, 15, 16, genre, Categorie.U17);
  }

  public List<Personne> getU18(int nombre, Genre genre) {
    return getPersonneJoueurMineur(nombre, 17, 18, genre, Categorie.U18);
  }

  public List<Personne> getPersonneJoueurMineur(
      int nombre, int minAge, int maxAge, Genre genre, Categorie categorie) {
    List<Personne> list = new ArrayList<>();
    for (int i = 0; i < nombre; i++) {
      Personne joueur = getPersonneMineur(minAge, maxAge, genre, categorie);
      Adresse adresse = getAdresse();
      Personne pere = getPersonneMajeur(Role.PERE, Genre.MASCULIN, null);
      pere.setNom(joueur.getNom());
      pere.setContacts(getContacts());
      pere.getAdresses().add(adresse);
      pere.setActiviteDansLeClub(
          ActiviteDansLeClub.builder()
              .joueur(false)
              .arbitre(false)
              .dirigeant(false)
              .entraineur(false)
              .build());
      Personne mere = getPersonneMajeur(Role.MERE, Genre.FEMININ, null);
      mere.setContacts(getContacts());
      mere.setNom(joueur.getNom());
      mere.getAdresses().add(adresse);
      mere.setActiviteDansLeClub(
          ActiviteDansLeClub.builder()
              .joueur(false)
              .arbitre(false)
              .dirigeant(false)
              .entraineur(false)
              .build());

      joueur.getFamille().add(mere);
      joueur.getFamille().add(pere);

      list.add(joueur);
    }
    return list;
  }
}
