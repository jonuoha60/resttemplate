package com.example.apis.entity;

import java.util.List;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data //this is a lombok for getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class Countries {
    private String iso2;

    private String iso3;

    private String country;

    private List<City> cities;
}
