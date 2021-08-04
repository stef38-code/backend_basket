package com.stephane.backend.basketball.utils.data;

import com.stephane.backend.basketball.entities.Adresse;

public class JeuxDonneesAdresse extends JeuxDonneesUtils {

    protected Adresse getAdresse() {
        String zipCode = faker.address().zipCode();
        return Adresse.builder()
                .ligne1(faker.address().streetAddress())
                .ligne2(faker.address().secondaryAddress())
                .codePostal(zipCode)
                .commune(faker.address().cityName())
                .build();
    }
}
