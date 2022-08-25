package com.multitenancy.modules.schemas.converter;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multitenancy.modules.schemas.routeCoord.dto.LatLongDto;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ConverterLatLongDto implements AttributeConverter<LatLongDto, String> {

    private final ObjectMapper mapper = new ObjectMapper();
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(LatLongDto attribute) {
        if (attribute == null) return null;
        return mapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public LatLongDto convertToEntityAttribute(String dbData) {
        if (dbData.isBlank()) return null;
        return mapper.readValue(dbData, LatLongDto.class);
    }
}
