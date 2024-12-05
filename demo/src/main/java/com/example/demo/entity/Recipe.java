package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe{

    @Id
    private Long id;

    private String name;

    @ElementCollection
    @Lob
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredient", columnDefinition = "TEXT")
    private List<String> ingredients;

    @ElementCollection
    @Lob
    @CollectionTable(name = "recipe_instructions", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "instruction", columnDefinition = "TEXT")
    private List<String> instructions;

    private int prepTimeMinutes;
    private int cookTimeMinutes;
    private int servings;
    private String difficulty;
    private String cuisine;
    private int caloriesPerServing;

    @ElementCollection
    @Lob
    @CollectionTable(name = "recipe_tags", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "tag",columnDefinition = "TEXT")
    private List<String> tags;

    private int userId;
    private String image;
    private Double rating;
    private int reviewCount;

    @ElementCollection
    @CollectionTable(name = "recipe_meal_types", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "meal_type")
    private List<String> mealType;


}
