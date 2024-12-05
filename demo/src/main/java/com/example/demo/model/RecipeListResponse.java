package com.example.demo.model;

import java.util.List;

public class RecipeListResponse {
    private List<RecipeDTO> recipes;

    public List<RecipeDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }
}
