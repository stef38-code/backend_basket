package com.stephane.backend.basketball.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "adresse")
public class Adresse extends AbstractEntityBase<String> {

    @Column(name = "adr_lig1")
    private String ligne1;

    @Column(name = "adr_lig2")
    private String ligne2;

    @Column(name = "adr_lig3")
    private String ligne3;

    @Column(name = "adr_lig4")
    private String ligne4;

    @Column(name = "adr_cp")
    private String codePostal;

    @Column(name = "adr_commune")
    private String commune;

    @Column(name = "adr_pays")
    private String pays;
}
