package com.barteksmalec.sfgrecipeproject.services;

import com.barteksmalec.sfgrecipeproject.commands.RecipeCommand;
import com.barteksmalec.sfgrecipeproject.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);

    void deletById(Long id);
}
