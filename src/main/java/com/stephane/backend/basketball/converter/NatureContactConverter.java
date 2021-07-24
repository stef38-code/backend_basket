package com.stephane.backend.basketball.converter;

import com.stephane.backend.basketball.entities.constantes.NatureContact;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class NatureContactConverter implements AttributeConverter<NatureContact, String> {

    @Override
    public String convertToDatabaseColumn(NatureContact natureContact) {
        if (natureContact == null) {
            return null;
        }
        return natureContact.getCode();
    }

    @Override
    public NatureContact convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(NatureContact.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
