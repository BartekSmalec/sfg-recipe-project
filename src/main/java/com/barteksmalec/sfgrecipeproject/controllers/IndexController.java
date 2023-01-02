package com.barteksmalec.sfgrecipeproject.controllers;

import com.barteksmalec.sfgrecipeproject.model.Category;
import com.barteksmalec.sfgrecipeproject.model.UnitOfMeasure;
import com.barteksmalec.sfgrecipeproject.repositories.CategoryRepository;
import com.barteksmalec.sfgrecipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is:" + categoryOptional.get().getId());
        System.out.println("Uom Id is:" + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
