package com.sda.shop.controllers;

import com.sda.shop.models.CartProduct;
import com.sda.shop.models.Product;
import com.sda.shop.services.ProductServise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ProductsController {
    MainController mainController = new MainController();
    private ProductServise productServise;

    public ProductsController(ProductServise productServise) {
        this.productServise = productServise;
    }

    @GetMapping()
    public String shop () {
        return "shop";
    }
    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("productsList", productsList());
        return "products";
    }

    @GetMapping("/products/product/{id}")
    public String getProductDetailsByID(Model model, @PathVariable String id) {
        int iid = Integer.parseInt(id);
        for (Product product : productsList()) {
            if (iid == product.getId()) {
                model.addAttribute("product", product);
                CartProduct cp = new CartProduct();
                cp.setProductName(product.getName());
                cp.setProductId(product.getId());
                model.addAttribute("CartProduct", cp);
            }
        }
        return "product";
    }

    public List<Product> productsList() {
        return productServise.getAllProducts();
    }

    @GetMapping("/newproduct")
    public String adminOpenAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "newproduct";
    }

    @PostMapping("/newproduct")
    public String adminAddProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
//        product.setId(Product.ID_GENERATOR++);
        productServise.addProduct(product);
        return "redirect:/shop/products";
    }

    @GetMapping("/removeproduct")
    public String OpenremoveProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "removeproduct";
    }

    @PostMapping("/removeproduct")
    public String removeProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        productServise.removeProductByID(product);
        return "redirect:/shop/products";
    }
}
