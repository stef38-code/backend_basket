package com.stephane.backend.basketball.converter;

import com.stephane.backend.basketball.entities.constantes.Categorie;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategorieConverter implements AttributeConverter<Categorie, String> {

    @Override
    public String convertToDatabaseColumn(Categorie categorie) {
        if (categorie == null) {
            return null;
        }
        return categorie.getCode();
    }

    @Override
    public Categorie convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Categorie.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
