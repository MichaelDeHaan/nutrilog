package com.csc340.nutrilogdemo;

import com.csc340.nutrilogdemo.food.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String showIndex(Model model) {
        return "index";
    }

    @GetMapping("/index.html")
    public String showIndexAlt(Model model) {
        return "index";
    }
}
