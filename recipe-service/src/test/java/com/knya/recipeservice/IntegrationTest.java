package com.knya.recipeservice;



import com.knya.recipeservice.controllers.Controller;
import com.knya.recipeservice.models.Recipe;
import com.knya.recipeservice.repositories.RecipeRepository;
import com.knya.recipeservice.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(Controller.class)
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @MockBean
    private RecipeRepository recipeRepository;

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/recipe/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("RECIPE"));
    }

    @Test
    public void testFindAll() throws Exception {
        when(recipeService.findAll()).thenReturn(Arrays.asList(new Recipe(4L,"Рецепт 1", "Описание"), new Recipe(5L,"Рецепт 2", "Описание")));

        mockMvc.perform(get("/recipe/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(4L))
                .andExpect(jsonPath("$[0].title").value("Рецепт 1"))
                .andExpect(jsonPath("$[0].description").value("Описание"));

        verify(recipeService, times(1)).findAll();
    }
    @Test
    void testGetByIdEndpoint() throws Exception {
        // Arrange
        Long id = 4L;
        when(recipeService.findById(id)).thenReturn("Рецепт 1 Описание: Описание");

        // Act & Assert
        mockMvc.perform(get("/recipe/4"))
                .andExpect(status().isOk())
                .andExpect(content().string("Рецепт 1 Описание: Описание"));

        // Verify that pcService.findByTitle() was called with the correct parameter
        verify(recipeService, times(1)).findById(id);
    }
}
