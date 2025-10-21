package com.example.demo.file.parser.impl;

import com.example.demo.dto.ApartmentDto;
import com.example.demo.file.FileContentType;
import com.example.demo.file.parser.ApartmentFileParser;
import com.example.demo.mapper.ApartmentMapper;
import com.example.demo.model.Apartment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JsonApartmentFileParser implements ApartmentFileParser {
    private final ObjectMapper mapper;
    private final ApartmentMapper apartmentMapper;

    @Override
    public List<Apartment> parse(Path path) throws IOException {
        List<ApartmentDto> dtos = mapper.readValue(path.toFile(), new TypeReference<>() {});
        return dtos.stream().map(apartmentMapper::toModel).toList();
    }

    @Override
    public FileContentType getSupportedType() {
        return FileContentType.JSON;
    }
}
