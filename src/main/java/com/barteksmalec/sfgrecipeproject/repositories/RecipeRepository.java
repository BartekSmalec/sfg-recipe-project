package com.barteksmalec.sfgrecipeproject.repositories;

import com.barteksmalec.sfgrecipeproject.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
