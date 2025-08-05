package com.example.apis.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {
    private boolean error;

    private String msg;

    private List<Countries> data;


    
}
