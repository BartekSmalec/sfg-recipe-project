package com.barteksmalec.sfgrecipeproject.controllers;

import com.barteksmalec.sfgrecipeproject.model.Recipe;
import com.barteksmalec.sfgrecipeproject.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;



class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController indexController;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }

    @Test
    void getIndexPage() {
        Set<Recipe> recipeSet =  new HashSet<>();
        recipeSet.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setDescription("test");
        recipeSet.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeSet);

        ArgumentCaptor<Set<Recipe>> argumentCaptor =  ArgumentCaptor.forClass(Set.class);

        String viewName = indexController.getIndexPage(model);

        assertEquals("index", viewName);
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Mockito.verify(model,Mockito.times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}