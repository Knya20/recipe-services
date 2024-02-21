package com.knya.recipeservice.services;

import com.knya.recipeservice.dto.RecipeReq;
import com.knya.recipeservice.exceptions.AppError;
import com.knya.recipeservice.models.Recipe;
import com.knya.recipeservice.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public ResponseEntity<?> create(RecipeReq recipeReq){
        try {
            Recipe recipe = new Recipe();
            recipe.setDescription(recipeReq.getDescription());
            recipe.setTitle(recipeReq.getTitle());
            recipeRepository.save(recipe);
            return new ResponseEntity<>(new AppError(HttpStatus.OK.value(), "Рецепт добавлен"), HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Ошибка создания");
        }
    }

    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok().body(recipeRepository.findAll());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Ошибка");
        }
    }

    public ResponseEntity<?> findById(Long id){
        try {
            return ResponseEntity.ok().body(recipeRepository.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Ошибка");
        }
    }
}
