package com.bonappetit.controller;

import com.bonappetit.model.dto.RecipesAddBindingModel;
import com.bonappetit.service.RecipeService;
import com.bonappetit.service.impl.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final LoggedUser loggedUser;

    public RecipeController(RecipeService recipeService, LoggedUser loggedUser) {
        this.recipeService = recipeService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/recipes/add")
    public ModelAndView add(@ModelAttribute("recipesAddBindingModel") RecipesAddBindingModel recipesAddBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("recipe-add");
    }

    @PostMapping("/recipes/add")
    public ModelAndView add(
            @ModelAttribute("recipesAddBindingModel") @Valid RecipesAddBindingModel recipesAddBindingModel,
            BindingResult bindingResult) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("recipe-add");
        }

        recipeService.addedBy(recipesAddBindingModel);

        return new ModelAndView("redirect:/home");
    }
}
