package com.example.demo;

import com.example.demo.file.FileContentType;
import com.example.demo.file.parser.ApartmentFileParser;
import com.example.demo.file.writer.BuildingFileWriter;
import com.example.demo.model.Apartment;
import com.example.demo.model.Building;
import com.example.demo.service.ApartmentService;
import com.example.demo.service.BuildingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public Map<FileContentType, ApartmentFileParser> apartmentFileParserMap(List<ApartmentFileParser> apartmentFileParsers) {
        return apartmentFileParsers.stream()
                .collect(Collectors.toMap(
                        ApartmentFileParser::getSupportedType,
                        Function.identity())
                );
    }

    @Bean
    public Map<FileContentType, BuildingFileWriter> buildingFileWriterMap(List<BuildingFileWriter> buildingFileWriters) {
        return buildingFileWriters.stream()
                .collect(Collectors.toMap(
                        BuildingFileWriter::getSupportedType,
                        Function.identity())
                );
    }

    @Bean
    public ApplicationRunner applicationRunner(ApartmentService apartmentService,
                                               BuildingService buildingService,
                                               Map<FileContentType, BuildingFileWriter> buildingFileWriterMap
                                               ) {
        return a -> {
            Scanner sc = new Scanner(System.in);
            String outputPath = sc.nextLine();
            List<Apartment> apartments = apartmentService.findAllApartment();
            List<Building> buildings = buildingService.groupAndSortByAddress(apartments);
            buildingFileWriterMap.get(FileContentType.JSON).write(buildings, Path.of(outputPath));
        };
    }
}
