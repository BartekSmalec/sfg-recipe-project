package com.barteksmalec.sfgrecipeproject.services;

import com.barteksmalec.sfgrecipeproject.model.Recipe;
import com.barteksmalec.sfgrecipeproject.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }
    @Test
    void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        Mockito.when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes =  recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        Mockito.verify(recipeRepository, times(1)).findAll();
    }
}