package com.example.tacos.web;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.tacos.Ingredient;
import com.example.tacos.Taco;
import com.example.tacos.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import com.example.tacos.Ingredient.*;

import javax.validation.Valid;

@Slf4j      // auto-config the log
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")     // Figure out this purpose
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        log.info("addIngredientsToModel: ");

    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        log.info("add TacoOrder To Model: ");

        return new TacoOrder();  // return the value of model attribute, tacoOrder
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        log.info("add Taco To Model: ");

        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        
        log.info("Handle the get request and show the design.html template");
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco,
                              Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {

        if (errors.hasErrors()) {
            log.debug("Processing taco errors: " + errors.toString());
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}