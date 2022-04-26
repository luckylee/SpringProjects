package com.example.tacos.web;

import com.example.tacos.domain.Taco;
import com.example.tacos.domain.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(@ModelAttribute TacoOrder tacoOrder) {
        // TODO() Get Taco object and log the ingredients
        List<Taco> tacos = tacoOrder.getTacos();
        for (Taco taco : tacos) {
            log.info("Taco name: {} ", taco.getName());
        }

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            log.debug("Order processing error: {} ", errors);
            return "orderForm";
        }

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}