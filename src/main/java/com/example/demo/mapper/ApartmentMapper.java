package com.example.demo.mapper;

import com.example.demo.dto.ApartmentDto;
import com.example.demo.model.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApartmentMapper {

    Apartment toModel(ApartmentDto dto);

    ApartmentDto toDto(Apartment model);
}