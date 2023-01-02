package com.barteksmalec.sfgrecipeproject.services;

import com.barteksmalec.sfgrecipeproject.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
