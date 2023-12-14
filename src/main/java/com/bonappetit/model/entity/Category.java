package com.bonappetit.model.entity;

import com.bonappetit.model.enums.CategoryName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryName name;

    @NotNull
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Recipe> recipes = new HashSet<>();



    private void setDescription(CategoryName name) {
        String description = "";


        switch (name) {
            case MAIN_DISH -> description = "Heart of the meal, substantial and satisfying; main dish delights taste buds.";
            case DESSERT -> description = "Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy.";
            case COCKTAIL -> description = "Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass.";
        }
        this.description= description;
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
        setDescription(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
