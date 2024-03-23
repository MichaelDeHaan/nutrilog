package com.csc340.nutrilogdemo.user;

import com.csc340.nutrilogdemo.food.Food;
import com.csc340.nutrilogdemo.food.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/user-bs.html")
    public String showUserPage(Model model) {
        return "user-bs";
    }

    @GetMapping("/templates/user/u-search.html")
    public String showSearchPage(Model model) {
        Food food = new Food();
        model.addAttribute("food", food);
        return "/user/u-search";
    }

    @PostMapping("/templates/user/u-search.html")
    public String searchSubmit(@ModelAttribute Food food, Model model){
        new FoodService().findMacros(food);
        model.addAttribute("food",food);
        return "result";
    }
}
