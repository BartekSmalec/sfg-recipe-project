package com.barteksmalec.sfgrecipeproject.converters;

import com.barteksmalec.sfgrecipeproject.commands.CategoryCommand;
import com.barteksmalec.sfgrecipeproject.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Override
    public CategoryCommand convert(Category source) {
        if (source == null) return null;

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }
}
