package com.example.demo.persistence.dao;

import com.example.demo.entity.Recipe;
import com.example.demo.persistence.repo.RecipeRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class RecipeDao {

    private static final Logger log = LoggerFactory.getLogger(RecipeDao.class);
    @Autowired
    RecipeRepo recipeRepo;

    public Optional<Recipe> getRecipeById(Long recipeId) {
        Optional<Recipe> recipe =  recipeRepo.findById(recipeId);

        log.info("recipe " + recipe);
        return recipe;
    }


}
