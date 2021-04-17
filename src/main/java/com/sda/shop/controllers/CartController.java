package com.sda.shop.controllers;

import com.sda.shop.models.CartItem;
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
        items.add(new CartItem(1l, "Wodka", "5"));
    }

    @GetMapping("/list")
    public String getCartItems(Model model) {
        CartItem cartItem = null;
        model.addAttribute("allItems", items);
        return "cart";
    }

    @PostMapping("/add")
    public String addProductToCart(CartItem cartItem) {
        items.add(cartItem);
        return "redirect:/products/product/" + cartItem.getProductId();
    }
}
