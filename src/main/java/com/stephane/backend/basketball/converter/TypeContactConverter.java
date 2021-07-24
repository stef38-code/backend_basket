package com.stephane.backend.basketball.converter;

import com.stephane.backend.basketball.entities.constantes.TypeContact;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TypeContactConverter implements AttributeConverter<TypeContact, String> {

    @Override
    public String convertToDatabaseColumn(TypeContact typeContact) {
        if (typeContact == null) {
            return null;
        }
        return typeContact.getCode();
    }

    @Override
    public TypeContact convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(TypeContact.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
