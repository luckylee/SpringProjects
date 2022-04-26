package com.example.tacos.web;


import com.example.tacos.data.IngredientRepository;
import com.example.tacos.domain.Ingredient;
import com.example.tacos.domain.Ingredient.Type;
import com.example.tacos.domain.Taco;
import com.example.tacos.domain.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j      // auto-config the log
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")     // Figure out this purpose
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        // Change to use repo methods to get ingredients
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

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