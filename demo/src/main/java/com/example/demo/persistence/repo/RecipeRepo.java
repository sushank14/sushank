package com.example.demo.persistence.repo;

import com.example.demo.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository< Recipe, Long> {
}
