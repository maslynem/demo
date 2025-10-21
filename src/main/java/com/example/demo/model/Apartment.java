package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartment {
    private String address;
    private String apartment;
    private String price;
    private String livingArea;
    private String rooms;
    private String floor;
    private String entrance;
}
