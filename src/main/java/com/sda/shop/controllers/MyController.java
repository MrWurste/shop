package com.sda.shop.controllers;

import com.sda.shop.CartItem;
import com.sda.shop.Product;
import com.sda.shop.services.ProductServise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    //private List<Product> listOfProducts = new ArrayList<>();
    private ProductServise productServise;
    Product current;
    int mygold = 5;

    public MyController(ProductServise productServise) {
        this.productServise=productServise;
    }
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

    @GetMapping("/products/product/{id}")
    public String getProductDetailsByID(Model model, @PathVariable String id) {
        int iid = Integer.parseInt(id);
        for (Product p : productsList()) {
            if (iid == p.getId()) {
                model.addAttribute("product", p);
                CartItem ci = new CartItem();
                ci.setProductName(p.getName());
                ci.setProductId(p.getId());
                model.addAttribute("CartItem", ci);
            }
        }
        model.addAttribute("goldInPoach", mygold);
        return "product";
    }

    public List<Product> productsList() {
        return productServise.getAllProducts();
    }

    @GetMapping("/newproduct")
    public String adminOpenAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin";
    }

    @PostMapping("/newproduct")
    public String adminAddProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
//        product.setId(Product.ID_GENERATOR++);
        productServise.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/removeproduct")
    public String OpenremoveProductForm (Model model) {
        model.addAttribute("product", new Product());
        return "removeProduct";
    }

    @PostMapping("/removeproduct")
    public String removeProduct (@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        productServise.removeProductByID(product);
        return "redirect:/products";
    }

    @GetMapping("/game")
    public String gameSite() {
        return "game";
    }
}
