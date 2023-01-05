package com.barteksmalec.sfgrecipeproject.services;

import com.barteksmalec.sfgrecipeproject.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndId(Long recipeId, Long ingredientId);
}
