package com.bonappetit.model.dto;

import com.bonappetit.model.entity.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RecipesAddBindingModel {

    @Size(min = 2, max = 40, message = "Name length must be between 2 and 40 characters!")
    private String name;

    @Size(min = 2, max = 80, message = "Ingredients length must be between 2 and 80 characters!")
    private String ingredients;

    @NotNull(message = "You must select a category!")
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
