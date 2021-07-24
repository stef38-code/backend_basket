package com.stephane.backend.basketball.utils;

import com.stephane.backend.basketball.entities.constantes.Genre;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenreConverterTest {
    private GenreConverter converter = new GenreConverter();

    @Test
    void testConvertToDatabaseColumn() {
        assertThat(converter.convertToDatabaseColumn(Genre.MASCULIN)).isEqualTo("M");
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void testConvertToEntityAttribute_Exception() {
        Assertions.assertThatThrownBy(() -> converter.convertToEntityAttribute("Code"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testConvertToEntityAttribute_M() {
        assertThat(converter.convertToEntityAttribute("M")).isEqualTo(Genre.MASCULIN);
    }

    @Test
    void testConvertToEntityAttribute_NullValue() {
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }
}

