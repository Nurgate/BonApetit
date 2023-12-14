package com.bonappetit.service.impl;

import com.bonappetit.model.dto.RecipesAddBindingModel;
import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.repo.CategoryRepository;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.repo.UserRepository;
import com.bonappetit.service.RecipeService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    public RecipeServiceImpl(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addedBy(RecipesAddBindingModel recipesAddBindingModel) {
        Category category = categoryRepository.findByName(recipesAddBindingModel.getCategory());

        if (category != null) {
            Recipe recipe = new Recipe();
            recipe.setIngredients(recipesAddBindingModel.getIngredients());
            recipe.setCategory(category);

            recipeRepository.save(recipe);
        }

    }
}