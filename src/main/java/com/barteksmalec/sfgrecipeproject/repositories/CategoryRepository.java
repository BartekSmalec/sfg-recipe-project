package com.barteksmalec.sfgrecipeproject.repositories;

import com.barteksmalec.sfgrecipeproject.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
