package com.example.apis.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posts {
    private int userId;
    private int id;
    private String title;
    private String body;
}
