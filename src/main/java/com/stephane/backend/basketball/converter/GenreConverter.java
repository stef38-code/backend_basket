package com.stephane.backend.basketball.converter;

import com.stephane.backend.basketball.entities.constantes.Genre;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenreConverter implements AttributeConverter<Genre, String> {

    @Override
    public String convertToDatabaseColumn(Genre genre) {
        if (genre == null) {
            return null;
        }
        return genre.getCode();
    }

    @Override
    public Genre convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Genre.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
