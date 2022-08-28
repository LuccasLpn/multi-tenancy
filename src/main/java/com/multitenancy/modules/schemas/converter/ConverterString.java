package com.multitenancy.modules.schemas.converter;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.List;

@Converter
public class ConverterString implements AttributeConverter<List<String>,String> {

    private final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null) return null;
        return mapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if(dbData.isEmpty()) return Collections.emptyList();
        return List.of(mapper.readValue(dbData, String[].class));
    }

}
