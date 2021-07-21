package com.stephane.backend.basketball.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data(staticConstructor = "of")
@NoArgsConstructor
@Entity
@Table(name = "personne")
public class Personne {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "datenaiss")
    private LocalDate datenaiss;

    private Genre genre;
    private Role role;
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
