package com.example.demo.controller;

import com.example.demo.entity.Recipe;
import com.example.demo.persistence.dao.RecipeDao;
import com.example.demo.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class recipesController {
    private static final Logger log = LoggerFactory.getLogger(recipesController.class);
    @Autowired
    RecipeDao recipeDao;
    @Autowired
    MyService myService;

    @GetMapping("/{recipeId}")
    public Optional<Recipe> getRecipeById(@PathVariable Long recipeId){
            log.info("recipe is  "+recipeId);
        return recipeDao.getRecipeById(recipeId);
    }

    @GetMapping("/recipes")
    public String getRecipes(){
        myService.fetchAndSaveRecipes();
        return "savedAllRecipes";
    }
}
