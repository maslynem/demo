package com.example.demo.file.writer.impl;

import com.example.demo.dto.BuildingDto;
import com.example.demo.file.FileContentType;
import com.example.demo.file.writer.BuildingFileWriter;
import com.example.demo.mapper.BuildingMapper;
import com.example.demo.model.Building;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JsonBuildingFileWriter implements BuildingFileWriter {
    private final ObjectMapper mapper;
    private final BuildingMapper buildingMapper;

    @Override
    public void write(List<Building> buildings, Path outPath) throws IOException {
        List<BuildingDto> dtos = buildings.stream().map(buildingMapper::toDto).toList();
        mapper.writeValue(outPath.toFile(), dtos);
    }

    @Override
    public FileContentType getSupportedType() {
        return FileContentType.JSON;
    }
}
