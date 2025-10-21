package com.example.demo.service;

import com.example.demo.model.Apartment;
import com.example.demo.model.Building;

import java.util.List;

public interface BuildingService {
    List<Building> groupAndSortByAddress(List<Apartment> apartments);
}
