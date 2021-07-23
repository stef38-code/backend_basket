package com.stephane.backend.basketball.utils;

import com.stephane.backend.basketball.entities.Genre;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenreConverterTest {
    private GenreConverter converter = new GenreConverter();
    @Test
    public void testConvertToDatabaseColumn() {
        assertThat(converter.convertToDatabaseColumn(Genre.MASCULIN)).isEqualTo("M");
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    public void testConvertToEntityAttribute_Exception() {
        Assertions.assertThatThrownBy(() -> converter.convertToEntityAttribute("Code"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testConvertToEntityAttribute_M() {
        assertThat(converter.convertToEntityAttribute("M")).isEqualTo(Genre.MASCULIN);
    }

    @Test
    public void testConvertToEntityAttribute_NullValue() {
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }
}

