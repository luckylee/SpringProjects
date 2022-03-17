package com.weginlee.apidemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    //public String hello(@RequestParam(value = "name", defaultValue = "Wegin") String name) {
    public String hello() {
        // Use the http://localhost:8080/hello?name=Sophia to try
        // return String.format("Welcome to the world of SpringBoot, %s !", name);
        return String.format("Hello World");
    }

}
