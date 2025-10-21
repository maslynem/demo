package com.example.demo.file.writer;

import com.example.demo.file.FileContentType;
import com.example.demo.model.Building;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface BuildingFileWriter {
    void write(List<Building> buildings, Path outPath) throws IOException;

    FileContentType getSupportedType();
}
