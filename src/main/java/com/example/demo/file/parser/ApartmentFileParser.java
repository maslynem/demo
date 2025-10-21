package com.example.demo.file.parser;

import com.example.demo.file.FileContentType;
import com.example.demo.model.Apartment;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ApartmentFileParser {
    List<Apartment> parse(Path path) throws IOException;

    FileContentType getSupportedType();
}
