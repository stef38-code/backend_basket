package com.stephane.backend.basketball.entities;

import com.stephane.backend.basketball.entities.constantes.NatureContact;
import com.stephane.backend.basketball.entities.constantes.TypeContact;
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
@Table(name = "contact")
public class Contact extends AbstractEntityBase<String> {

    @Column(name = "typecontact")
    private TypeContact typecontact;

    @Column(name = "naturecontact")
    private NatureContact naturecontact;

    @Column(name = "value")
    private String valeur;

}
