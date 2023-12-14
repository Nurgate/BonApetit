package com.bonappetit.init;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.enums.CategoryName;
import com.bonappetit.repo.CategoryRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeInit implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public RecipeInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = categoryRepository.count();

        if (count == 0) {
            List<Category> categories = new ArrayList<>();

            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        categories.add(category);
                    });

            categoryRepository.saveAll(categories);
        }
    }
}
