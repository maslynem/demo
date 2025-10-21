package com.example.demo.mapper;

import com.example.demo.dto.BuildingDto;
import com.example.demo.model.Building;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ApartmentMapper.class)
public interface BuildingMapper {

    BuildingDto toDto(Building building);

}