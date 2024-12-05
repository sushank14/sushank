package com.example.demo.service;

import com.example.demo.entity.Recipe;
import com.example.demo.model.RecipeDTO;
import com.example.demo.model.RecipeListResponse;
import com.example.demo.persistence.repo.RecipeRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MyService {


    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final RecipeRepo recipeRepository;
    @Autowired
    public MyService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper, RecipeRepo recipeRepository) {
        this.webClient = webClientBuilder.baseUrl("https://dummyjson.com").build();
        this.objectMapper = objectMapper;
        this.recipeRepository = recipeRepository;
    }

    public void fetchAndSaveRecipes() {
        List<RecipeDTO> recipeDTOs = webClient.get()
                .uri("/recipes")
                .retrieve()
                .bodyToMono(RecipeListResponse.class)
                .block()
                .getRecipes();

        List<Recipe> recipes = recipeDTOs.stream().map(this::convertToEntity).collect(Collectors.toList());
        recipeRepository.saveAll(recipes);
    }

    private Recipe convertToEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setId(dto.getId());
        recipe.setName(dto.getName());

        try {

            recipe.setIngredients(Collections.singletonList(objectMapper.writeValueAsString(dto.getIngredients())));
            recipe.setInstructions(Collections.singletonList(objectMapper.writeValueAsString(dto.getInstructions())));
            recipe.setTags(Collections.singletonList(objectMapper.writeValueAsString(dto.getTags())));
            recipe.setMealType(Collections.singletonList(objectMapper.writeValueAsString(dto.getMealType())));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert list to JSON string", e);
        }

        recipe.setPrepTimeMinutes(dto.getPrepTimeMinutes());
        recipe.setCookTimeMinutes(dto.getCookTimeMinutes());
        recipe.setServings(dto.getServings());
        recipe.setDifficulty(dto.getDifficulty());
        recipe.setCuisine(dto.getCuisine());
        recipe.setCaloriesPerServing(dto.getCaloriesPerServing());
        recipe.setUserId(Math.toIntExact(dto.getUserId()));
        recipe.setImage(dto.getImage());
        recipe.setRating(dto.getRating());
        recipe.setReviewCount(dto.getReviewCount());

        return recipe;
    }
}
