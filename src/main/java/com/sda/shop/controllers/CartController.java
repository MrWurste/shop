package com.sda.shop.controllers;

import com.sda.shop.CartItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    List<CartItem> items;

    public CartController() {
        items = new ArrayList<>();
        items.add(new CartItem("1", "Wodka", "5"));
    }

    @GetMapping("/list")
    public String getCartItems(Model model) {
        model.addAttribute("allItems", items);
        return "cart";
    }

    @PostMapping("/add")
    public String addProductToCart(CartItem cartItem) {
        return "redirect:/products/" + cartItem.getProductId();
    }
}
