package com.bonappetit.service;

import com.bonappetit.model.dto.RecipesAddBindingModel;
import com.bonappetit.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeService {

    void addedBy(RecipesAddBindingModel recipesAddBindingModel);
}
