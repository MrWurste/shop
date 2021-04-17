package com.sda.shop.controllers;

import com.sda.shop.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KnightController {
    MainController mainController = new MainController();

    private Product currentWeapon = mainController.currentWeapon;

    @GetMapping("/knight")
    public String getKnightData(Model model) {
        if (null == currentWeapon) {
            mainController.currentWeapon = new Product("Ręce",
                    "Brak broni nie oznacza, że jesteś bezbronny. Twoją bronią są Twoje ręce i sam dobrze wiesz do czego są zdolne.",
                    "Hands.png", 0);
            currentWeapon = mainController.currentWeapon;
        }
        model.addAttribute("imie", "Zbyszko");
        model.addAttribute("bron", currentWeapon.getName());
        return "knight_details";
    }

}
