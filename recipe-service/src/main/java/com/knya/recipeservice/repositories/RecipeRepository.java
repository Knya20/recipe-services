package com.knya.recipeservice.repositories;

import com.knya.recipeservice.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByTitle(String title);
}
