package com.csc340.nutrilogdemo.food;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/")
    public String showPage(Model model) {
        Food food = new Food(foodService);
        foodService.updateFood(food);
        model.addAttribute("ingredients", food.getIngredients());
        model.addAttribute("protein", food.getProteinContent());
        model.addAttribute("fat", food.getFatContent());
        model.addAttribute("carb", food.getCarbContent());
        return "test";
    }
}
