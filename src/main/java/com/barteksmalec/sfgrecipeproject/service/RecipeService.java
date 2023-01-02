package com.barteksmalec.sfgrecipeproject.service;

import com.barteksmalec.sfgrecipeproject.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
