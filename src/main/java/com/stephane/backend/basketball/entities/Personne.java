package com.stephane.backend.basketball.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stephane.backend.basketball.entities.constantes.Categorie;
import com.stephane.backend.basketball.entities.constantes.Genre;
import com.stephane.backend.basketball.entities.constantes.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

// Lombok Annotations
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "personne")
/**
 * ref resolve erreur:
 * https://stackoverflow.com/questions/2302802/how-to-fix-the-hibernate-object-references-an-unsaved-transient-instance-save
 */
public class Personne extends AbstractEntityBase<String> {


  @Column(name = "nom")
  private String nom;

  @Column(name = "prenom")
  private String prenom;

  @Column(name = "datenaiss")
  private LocalDate datenaiss;

  @Column(name = "genre")
  private Genre genre;

  @Column(name = "role")
  private Role role;

  @Column(name = "categorie")
  private Categorie categorie;
  /** */
  @Embedded
    @AttributeOverride(
        name = "joueur",
        column =
            @Column(name = "joueur", columnDefinition = "boolean default  true", nullable = false))
    @AttributeOverride(
        name = "arbitre",
        column =
            @Column(
                name = "arbitre",
                columnDefinition = "boolean default  false",
                nullable = false))
    @AttributeOverride(
        name = "dirigeant",
        column =
            @Column(
                name = "dirigeant",
                columnDefinition = "boolean default  false",
                nullable = false))
    @AttributeOverride(
        name = "entraineur",
        column =
            @Column(
                name = "entraineur",
                columnDefinition = "boolean default  false",
                nullable = false))
   private ActiviteDansLeClub activiteDansLeClub;

  /** */
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @Builder.Default
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "famille",
      joinColumns = @JoinColumn(name = "personneID1", referencedColumnName = "ID", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "personneID2", referencedColumnName = "ID", nullable = false))
  @JsonManagedReference
  private Set<Personne> famille = new HashSet<>();

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @Builder.Default
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "adresses",
      joinColumns = @JoinColumn(name = "personneID1", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "adresseID", referencedColumnName = "ID"))

  private Set<Adresse> adresses = new HashSet<>();

  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @Builder.Default
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "contacts",
      joinColumns = @JoinColumn(name = "personneID1", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "contactID", referencedColumnName = "ID"))
  @JsonManagedReference
  private Set<Contact> contacts = new HashSet<>();
}
