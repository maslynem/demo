package com.example.demo.service.impl;

import com.example.demo.model.Apartment;
import com.example.demo.model.Building;
import com.example.demo.service.BuildingService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Override
    public List<Building> groupAndSortByAddress(List<Apartment> apartments) {
        Map<String, List<Apartment>> grouped = apartments.stream()
                .collect(Collectors.groupingBy(Apartment::getAddress));

        grouped.values().forEach(list -> list
                .sort(Comparator.comparingInt(a -> Integer.parseInt(a.getApartment()))));
        return grouped.entrySet().stream()
                .map(e -> new Building(e.getKey(), e.getValue()))
                .toList();
    }
}
