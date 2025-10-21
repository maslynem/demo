package com.example.demo.service.impl;

import com.example.demo.file.FileContentType;
import com.example.demo.file.parser.ApartmentFileParser;
import com.example.demo.model.Apartment;
import com.example.demo.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FileApartmentService implements ApartmentService {
    private final Map<FileContentType, ApartmentFileParser> apartmentFileParserMap;

    @Value("${demo.apartment.input.file.type}")
    private FileContentType fileContentType;

    @Value("${demo.apartment.input.file.path}")
    private Path inputPath;

    @Override
    public List<Apartment> findAllApartment() {
        try {
            ApartmentFileParser apartmentFileParser = apartmentFileParserMap.get(fileContentType);
            return apartmentFileParser.parse(inputPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
