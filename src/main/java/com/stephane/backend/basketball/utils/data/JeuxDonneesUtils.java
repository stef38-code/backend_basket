package com.stephane.backend.basketball.utils.data;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class JeuxDonneesUtils {
    protected final Faker faker = new Faker(new Locale("fr"));

    protected <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        SecureRandom random = new SecureRandom();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    protected LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
