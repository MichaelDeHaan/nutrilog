package com.csc340.nutrilogdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    //Does not currently work
    @GetMapping("/")
    public String showPage() {
        return "test";
    }
}