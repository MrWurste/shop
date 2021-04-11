package com.sda.shop.controllers;

import com.sda.shop.CartItem;
import com.sda.shop.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    List<Product> listOfProducts = new ArrayList<>();
    Product current;
    int mygold = 5;

    @GetMapping("/knight")
    public String getKnightData(Model model) {
        if (null == current) {
            current = productsList().get(0);
        }
        model.addAttribute("imie", "Zbyszko");
        model.addAttribute("bron", current.getName());
        return "knight_details";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("goldInPoach", mygold);
        model.addAttribute("productsList", productsList());
        return "products";
    }

    @GetMapping("products/product/{id}")
    public String getProductDetailsByID(Model model, @PathVariable String id) {
        Product product = null;
        CartItem cartItem = null;
        int iid = Integer.parseInt(id);
        for (Product p : productsList()) {
            if (iid == p.getId()) {
                product = p;
                break;
            }
        }
        model.addAttribute("goldInPoach", mygold);
        model.addAttribute("product", product);
        model.addAttribute("CartItem", cartItem);
        return "product";
    }

    public List<Product> productsList() {
        if (listOfProducts.isEmpty()) {
            Product product1 = new Product("nóż do masła",
                    "Prosty tępy nóż do masła, skoro widelcem można zabić smoka, to nożem do masła można zrobić jeszcze więcej.",
                    "ButterKnife.png", 5);
            Product product2 = new Product("miecz",
                    "Pierwsza normalna broń, szybka, ostra i skuteczna.",
                    "Sword.png", 60);
            Product product3 = new Product("topór",
                    "No i to jest coś! Tons of damage! No tylko wolniej się macha...",
                    "Axe.png", 120);
            listOfProducts.add(product1);
            listOfProducts.add(product2);
            listOfProducts.add(product3);
        }
        return listOfProducts;
    }

    @GetMapping("admin")
    public String adminOpenAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin";
    }

    @PostMapping("admin")
    public String adminAddProduct(Product product) {
        product.setId(Product.ID_GENERATOR++);
        listOfProducts.add(product);
        return "redirect:/products/";
    }

    public Product setCurrent() {
        return null;
    }
}
