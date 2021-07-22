package com.stephane.backend.basketball.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

// Lombok Annotations
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@Entity
@Table(name = "personne")

public class Personne extends AbstractEntityBase{
    /*@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;*/

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "datenaiss")
    private LocalDate datenaiss;

    private Genre genre;
    private Role role;
    @ManyToMany
    @JoinTable(name="activites",
            joinColumns=
            @JoinColumn(name="personneID1", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="activitesID", referencedColumnName="ID")
    )
    private Set<Activites> activites = new HashSet<>();
    /**
     *
     */
    @ManyToMany
    @JoinTable(name="famille",
            joinColumns=
            @JoinColumn(name="personneID1", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="personneID2", referencedColumnName="ID")
    )
    private Set<Personne> famille = new HashSet<>();



}
