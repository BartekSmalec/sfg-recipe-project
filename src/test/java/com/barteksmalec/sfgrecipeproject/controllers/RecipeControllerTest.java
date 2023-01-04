package com.barteksmalec.sfgrecipeproject.controllers;

import com.barteksmalec.sfgrecipeproject.model.Recipe;
import com.barteksmalec.sfgrecipeproject.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class RecipeControllerTest {
    @Mock
    RecipeService recipeService;

    RecipeController recipeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeController =  new RecipeController(recipeService);
    }

    @Test
    void showById() throws Exception {
        Recipe recipe =  new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        Mockito.when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }
}