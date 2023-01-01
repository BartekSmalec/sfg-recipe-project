package com.barteksmalec.sfgrecipeproject.repositories;

import com.barteksmalec.sfgrecipeproject.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
