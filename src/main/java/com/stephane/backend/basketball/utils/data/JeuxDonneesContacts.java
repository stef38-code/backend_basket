package com.stephane.backend.basketball.utils.data;

import com.stephane.backend.basketball.entities.Contact;
import com.stephane.backend.basketball.entities.constantes.NatureContact;
import com.stephane.backend.basketball.entities.constantes.TypeContact;

import java.util.HashSet;

public class JeuxDonneesContacts extends JeuxDonneesAdresse {
    protected HashSet<Contact> getContacts() {
        HashSet<Contact> contacts = new HashSet<Contact>();
        contacts.add(getContactEmail());
        contacts.add(getContactTel());
        return contacts;
    }

    private Contact getContactEmail() {
        return Contact.builder()
                .naturecontact(NatureContact.PERSONNEL)
                .typecontact(TypeContact.EMAIL)
                .valeur(faker.internet().emailAddress())
                .build();
    }

    private Contact getContactTel() {
        return Contact.builder()
                .naturecontact(NatureContact.PERSONNEL)
                .typecontact(TypeContact.TEL_PORTABLE)
                .valeur(faker.phoneNumber().cellPhone())
                .build();
    }
}
