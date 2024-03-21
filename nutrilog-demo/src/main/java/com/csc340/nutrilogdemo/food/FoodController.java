package com.csc340.nutrilogdemo.food;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {

    @GetMapping("/")
    public String showPage(Model model) {
        Food food = new Food();
        model.addAttribute("food", food);
        return "test";
    }

    @PostMapping("/")
    public String foodSubmit(@ModelAttribute Food food, Model model){
        new FoodService().findMacros(food);
        model.addAttribute("food",food);
        return "result";
    }
}