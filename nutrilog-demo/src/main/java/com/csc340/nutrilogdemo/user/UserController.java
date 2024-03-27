package com.csc340.nutrilogdemo.user;

import com.csc340.nutrilogdemo.food.Food;
import com.csc340.nutrilogdemo.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/user.html")
    public String showUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user";
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
        return "/user/u-result";
    }

//    SQL
    @PostMapping(path="/user.html")
    public String addNewUser(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        userRepository.save(user);
        return "redirect:/all";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
