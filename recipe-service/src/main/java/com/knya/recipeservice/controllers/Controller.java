package com.knya.recipeservice.controllers;

import com.knya.recipeservice.dto.RecipeReq;
import com.knya.recipeservice.models.Recipe;
import com.knya.recipeservice.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
public class Controller {

    private final RecipeService recipeService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RecipeReq recipeReq){
        return recipeService.create(recipeReq);
    }

    @GetMapping("/findAll")
    public List<Recipe> findAll(){
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id){
        return recipeService.findById(id);
    }

    @GetMapping("/test")
    public String test(){
        return "RECIPE";
    }

}
