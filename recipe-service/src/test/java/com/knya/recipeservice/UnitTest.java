package com.knya.recipeservice;

import com.knya.recipeservice.models.Recipe;
import com.knya.recipeservice.repositories.RecipeRepository;
import com.knya.recipeservice.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UnitTest {

    @InjectMocks
    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Test
    void testFindAll() {
        // Arrange
        List<Recipe> expectedPcList = Arrays.asList(new Recipe(4L,"Рецепт 1", "Описание"), new Recipe(5L,"Рецепт 2", "Описание"));
        when(recipeRepository.findAll()).thenReturn(expectedPcList);

        // Act
        List<Recipe> actualPcList = recipeService.findAll();

        // Assert
        assertEquals(expectedPcList, actualPcList);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void testFindByTitle() {
        // Arrange
        Long id = 4L;
        Recipe recipe = new Recipe(4L,"Рецепт 1", "Описание");
        Optional<Recipe> optionalRecipe = Optional.of(recipe);
        when(recipeRepository.findById(id)).thenReturn(optionalRecipe);

        // Act
        String result = recipeService.findById(id);

        // Assert
        assertEquals("Рецепт 1 Описание: Описание", result);
        verify(recipeRepository, times(1)).findById(id);
    }
}
