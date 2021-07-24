package com.stephane.backend.basketball.entities;

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
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "personne")
/**
 * ref resolve erreur: https://stackoverflow.com/questions/2302802/how-to-fix-the-hibernate-object-references-an-unsaved-transient-instance-save
 */
public class Personne extends AbstractEntityBase<String>{

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
    /**
     *
     */
    @Column(name = "joueur", columnDefinition = "boolean default  true", nullable = false)
    private boolean joueur;
    @Column(name = "arbitre", columnDefinition = "boolean default  false", nullable = false)
    private boolean arbitre;
    @Column(name = "dirigeant", columnDefinition = "boolean default  false", nullable = false)
    private boolean dirigeant;
    @Column(name = "entraineur", columnDefinition = "boolean default  false", nullable = false)
    private boolean entraineur;
    /**
     *
     */
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "famille",
            joinColumns =
            @JoinColumn(name = "personneID1", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "personneID2", referencedColumnName = "ID")
    )
    private Set<Personne> famille = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "adresses",
            joinColumns =
            @JoinColumn(name = "personneID1", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "adresseID", referencedColumnName = "ID")
    )
    private Set<Adresse> adresses = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "contacts",
            joinColumns =
            @JoinColumn(name = "personneID1", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "contactID", referencedColumnName = "ID")
    )
    private Set<Contact> contacts = new HashSet<>();
}
