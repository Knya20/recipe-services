package com.knya.recipeservice.controllers;

import com.knya.recipeservice.dto.RecipeReq;
import com.knya.recipeservice.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> findAll(){
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return recipeService.findById(id);
    }

    @GetMapping("/test")
    public String test(){
        return "Auth Service is Started!";
    }
}
