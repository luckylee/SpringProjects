package com.example.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//Try @Component, @Service or @Repository and find the different
public class HomeController {

    @GetMapping("/")
    public String home() {
        System.out.println("get home string");
        return "home";
    }
}