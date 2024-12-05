package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private String name;
    private List<String> ingredients;
    private List<String> instructions;
    private Integer prepTimeMinutes;
    private Integer cookTimeMinutes;
    private Integer servings;
    private String difficulty;
    private String cuisine;
    private Integer caloriesPerServing;
    private List<String> tags;
    private Long userId;
    private String image;
    private Double rating;
    private Integer reviewCount;
    private List<String> mealType;


}
