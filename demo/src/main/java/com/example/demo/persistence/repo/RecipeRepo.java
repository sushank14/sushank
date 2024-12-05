package com.example.demo.persistence.repo;

import com.example.demo.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository< Recipe, Long> {
    @Query("SELECT r FROM Recipe r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(r.cuisine) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Recipe> searchRecipes(@Param("keyword") String keyword);
}
