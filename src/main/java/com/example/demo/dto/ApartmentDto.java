package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApartmentDto {
    private String address;
    private String apartment;
    private String price;

    @JsonProperty("living_area")
    private String livingArea;

    private String rooms;
    private String floor;
    private String entrance;
}