package com.example.apis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatFact {
    private String fact;
    private int length;

    // No-arg constructor (required by Jackson)
   
}